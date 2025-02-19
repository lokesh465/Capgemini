import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.task.TaskExecutor;

@ExtendWith(MockitoExtension.class)
class MongoPurgeServiceImplTest {

    @Mock
    private MongoPurgeDao mongoPurgeDao;

    @Mock
    private MongoPurgeConfig mongoPurgeConfig;

    @Mock
    private TaskExecutor taskExecutor;

    @InjectMocks
    private MongoPurgeServiceImpl mongoPurgeService;

    private static final String COLLECTION_NAME = "testCollection";
    private AtomicLong totalDeletionCountPerCollection;

    @BeforeEach
    void setUp() {
        totalDeletionCountPerCollection = new AtomicLong(0);
        when(mongoPurgeConfig.getKeyAttribute()).thenReturn("key");
        when(mongoPurgeConfig.getDeleteAttribute()).thenReturn("delete");
        when(mongoPurgeConfig.getBatchSize()).thenReturn(10);
        when(mongoPurgeConfig.getPrintDeletedDocuments()).thenReturn(true);
    }

    @Test
    void testExecuteFindAndDelete_Success() throws ExecutionException, InterruptedException {
        List<String> documentsToDelete = List.of("doc1", "doc2");

        when(mongoPurgeDao.findDocumentsToDelete(anyString(), anyString(), anyInt()))
                .thenReturn(documentsToDelete);
        when(mongoPurgeDao.deleteDocuments(anyString(), anyList(), anyBoolean()))
                .thenReturn(2L);

        CompletableFuture<Long> result = mongoPurgeService.executeFindAndDelete(COLLECTION_NAME, null, totalDeletionCountPerCollection);

        assertEquals(2L, result.get());
        assertEquals(2L, totalDeletionCountPerCollection.get());
    }

    @Test
    void testExecuteFindAndDelete_NoDocumentsToDelete() throws ExecutionException, InterruptedException {
        when(mongoPurgeDao.findDocumentsToDelete(anyString(), anyString(), anyInt()))
                .thenReturn(Collections.emptyList());

        CompletableFuture<Long> result = mongoPurgeService.executeFindAndDelete(COLLECTION_NAME, null, totalDeletionCountPerCollection);

        assertEquals(0L, result.get());
        assertEquals(0L, totalDeletionCountPerCollection.get());
    }

    @Test
    void testExecuteFindAndDelete_DeletionFailure() throws ExecutionException, InterruptedException {
        List<String> documentsToDelete = List.of("doc1", "doc2");

        when(mongoPurgeDao.findDocumentsToDelete(anyString(), anyString(), anyInt()))
                .thenReturn(documentsToDelete);
        when(mongoPurgeDao.deleteDocuments(anyString(), anyList(), anyBoolean()))
                .thenReturn(0L);

        CompletableFuture<Long> result = mongoPurgeService.executeFindAndDelete(COLLECTION_NAME, null, totalDeletionCountPerCollection);

        assertEquals(0L, result.get());
        assertEquals(0L, totalDeletionCountPerCollection.get());
    }

    @Test
    void testExecuteFindAndDelete_ExceptionHandling() {
        when(mongoPurgeDao.findDocumentsToDelete(anyString(), anyString(), anyInt()))
                .thenThrow(new RuntimeException("DB error"));

        CompletableFuture<Long> result = mongoPurgeService.executeFindAndDelete(COLLECTION_NAME, null, totalDeletionCountPerCollection);

        assertDoesNotThrow(() -> result.get());
        assertEquals(0L, totalDeletionCountPerCollection.get());
    }
}