public class FibRunnable implements Runnable {

    Integer num;

    public FibRunnable(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            if(num == 0){
                Main.fibonacci[0] = 0;
            }else if(num == 1){
                Main.fibonacci[1] = 1;
                Main.fibRunnables[num-1].start();
                synchronized (Main.fibRunnables[num-1]){
                    Main.fibRunnables[num-1].join();
                }
            }else{
                Main.fibRunnables[num-1].start();
                synchronized (Main.fibRunnables[num-1]){
                    Main.fibRunnables[num-1].join();
                }
                Main.fibonacci[num] = Main.fibonacci[num-1] + Main.fibonacci[num-2];
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
