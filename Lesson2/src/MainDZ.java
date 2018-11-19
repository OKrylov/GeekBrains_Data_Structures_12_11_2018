import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainDZ {

    private static final int ARRAY_CAPACITY = 10_000;


    public static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
//        Supplier<Array> constructor = ArrayImpl::new;
        Supplier<Array> constructor = OrderedArrayImpl::new;


//        Array arr1 = new ArrayImpl(ARRAY_CAPACITY);
//        Array arr2 = new ArrayImpl(ARRAY_CAPACITY);
//        Array arr3 = new ArrayImpl(ARRAY_CAPACITY);
//
        Array arr1 = createArray(constructor);
        Array arr2 = createArray(constructor);
        Array arr3 = createArray(constructor);

        randomInitialize(arr1, arr2, arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        measureTime(new Runnable() {
//            @Override
//            public void run() {
//                arr1.sortBubble();
//            }
//        }, "Sort Bubble");


        List<Callable<Void>> tasks = List.of(
                measureTime(arr1::sortBubble, "Sort Bubble"),
                measureTime(arr2::sortSelect, "Sort Select"),
                measureTime(arr3::sortInsert, "Sort Insert")
        );

        for (Future<Void> future : executorService.invokeAll(tasks)) {
            future.get(1, TimeUnit.MINUTES);
        }

        executorService.shutdown();
    }

    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }

    private static Callable<Void> measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d ms.",
                    actionName,
                    TimeUnit.NANOSECONDS.toMillis(duration)));

            return null;
        };

    }

    private static Array createArray( Supplier<Array> factory) {
        return factory.get();
    }

}