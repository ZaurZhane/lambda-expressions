
public class Main {
    public static void main(String[] args) {

        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorCallback  = System.out::println;

        Worker worker = new Worker(listener, errorCallback);
        worker.start();

    }
}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String result);
}

class Worker implements OnTaskDoneListener, OnTaskErrorListener {

    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @Override
    public void onDone(String result) {
        System.out.print(result);
    }

    @Override
    public void onError(String result) {
        System.out.print(result);
    }

    public void start() {
        for (int i = 0; i < 100; i++) {

            if (i < 33) {
                errorCallback.onError("Task " + i + " is error");
            } else {
                callback.onDone("Task " + i + " is done");
            }

        }
    }
}

