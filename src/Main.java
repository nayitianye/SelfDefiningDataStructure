import java.util.ArrayList;
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

    private static double testSet(Set<String> set,String filename){
        long startTime=System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total words: "+words.size());
            for(String word:words){
                set.add(word);
            }
            System.out.println("Total different words: "+set.getSize());
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000;
    }

    private static double testMap(Map<String,Integer> map,String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {

        /*int opCount=30000000;
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: "+time1+" S");
        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time: "+time2+" S");
        LinkedListQueue<Integer> linkedListQueue=new LinkedListQueue<>();
        double time3=testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue, time: "+time3+" S");*/
       /* ArrayStack<Integer> arrayStack=new ArrayStack<>();
        double time4=testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time: "+time4+" S");

        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>();
        double time5=testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack, time: "+time5+" S");*/

       /* String  filename="pride-and-prejudice.txt";
        BinarySearchTreeSet<String> bstSet=new BinarySearchTreeSet<>();
        double time6=testSet(bstSet,filename);
        System.out.println("BST Set: "+time6+" s");
        System.out.println();

        LinkedListSet<String> linkedListSet=new LinkedListSet<>();
        double time7=testSet(linkedListSet,filename);
        System.out.println("LinkedListSet: "+time7+" s");*/

        /*String filename = "pride-and-prejudice.txt";

        BinarySearchTreeMap<String, Integer> bstMap = new BinarySearchTreeMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");*/

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
