import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
// import java.util.Scanner;
// import java.lang.Integer;

import classes.DeliveryBoy;
import classes.Order;

public class Scheduler{
    
    public static List<String> output;
    public static void main(String[] args) {
        
        // Scanner sc=new Scanner(System.in);
        int n,m;
        List<Order> orders=new ArrayList<>();
        PriorityQueue<DeliveryBoy> deliveryBoys=new PriorityQueue<>(
            (x,y)->x.freeTime!=y.freeTime?x.freeTime-y.freeTime: x.id-y.id);  //comparator for maintaining delivery boys according to their freeTime and then by id.

        //Taking input from database or system or Restaurant admin:
        // n= sc.nextInt();
        // m= sc.nextInt();
        // for(int i=0;i<n;i++){
        //     Order o=new Order();
        //     String input= sc.nextLine();
        //     String[] vars= input.split(",");
        //     o.setOrderTime(Integer.parseInt(vars[0]));
        //     o.setDeliveryTime(Integer.parseInt(vars[1]));
        //     orders.add(o);
        // }
        // sc.close();

        //Hardcoding a testcase
        n=6;
        m=2;
        for(int i=0;i<m;i++){
            DeliveryBoy boy=new DeliveryBoy(i,0);
            boy.setStatus("free");
            deliveryBoys.offer(boy);   //initial freeTime is 0 for each delivery boy.
        }
            
        Order o1=new Order();
        o1.setOrderTime(1);o1.setDeliveryTime(10);  orders.add(o1);
        Order o2=new Order();
        o2.setOrderTime(4);o2.setDeliveryTime(20);  orders.add(o2);
        Order o3=new Order();
        o3.setOrderTime(15);o3.setDeliveryTime(5);  orders.add(o3);
        Order o4=new Order();
        o4.setOrderTime(22);o4.setDeliveryTime(20); orders.add(o4);
        Order o5=new Order();
        o5.setOrderTime(24);o5.setDeliveryTime(10); orders.add(o5);
        Order o6=new Order();
        o6.setOrderTime(25);o6.setDeliveryTime(10); orders.add(o6);
       
        Collections.sort(orders,(x,y)-> x.getOrderTime()-y.getOrderTime());
        output=new ArrayList<>();
        schedule(orders,deliveryBoys,n);
        displayoutput();
    }

    public static void schedule(List<Order> orders,PriorityQueue<DeliveryBoy> deliveryBoys,int n){
        for(int i=0;i<n;i++){
            Order o= orders.get(i);
            int currTime= o.getOrderTime();
            DeliveryBoy boy= deliveryBoys.peek();
            
            if(boy!=null && boy.freeTime<=currTime){
                deliveryBoys.poll();
                boy.setStatus("busy");
                boy.freeTime= currTime+o.getDeliveryTime();  //updating the free time after assigning the delivery boy
                output.add("C"+(i+1)+" - D"+(boy.id+1));
                deliveryBoys.offer(boy);
            }
            else
                output.add("C"+(i+1)+" - No Food :-(");
            
        }
    }

    public static void displayoutput(){
        for(String s: output)
            System.out.println(s+"\n");
    }
}