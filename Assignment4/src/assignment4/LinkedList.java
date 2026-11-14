package assignment4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList {
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	//list using positive integers from file
	public void construct(String fname) {
		try {
			Scanner sc= new Scanner(new File(fname));
			
			//check all nums
			while (sc.hasNextInt()) {
				int value = sc.nextInt();
				//ignore negative values
				if (value > 0) {
					append(value);
				}	
			}
			
			sc.close();
		} catch (Exception e) {
			System.out.println("Error reading file: " + e);
		}
	}
	
	//adds new node at end
	private void append(int value) {
		Node newNode = new Node(value);
		
		//first node
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		//attach new node
		temp.next = newNode;
	}
	
	//insert node with 'value' after prev node
	private void insertAfter(Node prev, int value) {
		Node newNode = new Node(value);
		
		newNode.next = prev.next;
		prev.next = newNode;
	}
	
	//remove node after prev
	private void deleteNext(Node prev) {
		if (prev != null && prev.next != null) {
			prev.next = prev.next.next;
		}
	}
	
	//deletes head of LL
	private void deleteHead() {
		if (head != null) {
			head = head.next;
		}
	}
	
	//main processing
	public void process() {
		//starting count and only one shrink allowed
		int count = -100;
		boolean shrinkUsed = false;
		
		//one behind curr
		Node prev = null;
		//pointer
		Node curr = head;
		
		while (curr != null) {
			//check X[i] = X[i-1]*2+7
			if (!shrinkUsed && prev != null && curr.item == prev.item * 2 + 7) {
				if (prev == head) {
					//remove prev and curr
					deleteHead();
					deleteHead();
					//reset curr
					curr = head;
					prev = null;
				} else {
					//node before prev to delete from
					Node beforePrev = head;
					while (beforePrev.next != prev) {
						beforePrev = beforePrev.next;
					}
					//deletes prev then curr
					deleteNext(beforePrev);
					deleteNext(beforePrev);
					curr = beforePrev.next;
					prev = beforePrev;
				}
				
				//insert new count node
				if (prev == null) {
					//insert at front
					Node newNode = new Node(count);
					newNode.next = head;
					head = newNode;
					prev = head;
					curr = head.next;
				} else {
					//after prev
					insertAfter(prev, count);
					//move prev to new node
					prev = prev.next;
					curr = head.next;
				}
				//update count
				count--;
				//mark used
				shrinkUsed = true;
				continue;
			}
			//if no shrink traverse normally
			prev = curr;
			curr = curr.next;
		}
		
		//add count node
		append(count);
	}
	
	public void printToFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			Node temp = head;
			
			while(temp != null) {
				fw.write(Integer.toString(temp.item));
				//print if another number
				if (temp.next != null) {
					fw.write(" ");
				}
				temp = temp.next;
			}
			fw.close();
		} catch(IOException e) {
			System.out.println("Error writing file: " + e);
		}
	}
}
