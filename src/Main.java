import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime=System.nanoTime();
        Random random=new Random();
        for(int i=0;i<opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            q.dequeue();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000;
    }

    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime=System.nanoTime();
        Random random=new Random();
        for(int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000;
    }
    public static void main(String[] args) {
        int opCount=30000000;
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: "+time1+" S");
        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: "+time2+" S");
        LinkedListQueue<Integer> linkedListQueue=new LinkedListQueue<>();
        double time3=testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue, time: "+time3+" S");
       /* ArrayStack<Integer> arrayStack=new ArrayStack<>();
        double time3=testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time: "+time3+" S");

        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>();
        double time4=testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack, time: "+time4+" S");*/
    }
}
