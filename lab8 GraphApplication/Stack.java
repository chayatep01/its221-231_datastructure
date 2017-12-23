package lab8;

class Stack<T> {

    private SList<T> list = new SList<T>();

    Stack() {
    }

    void push(T element) {
        list.addFirst(element);
    }

    T pop() {
        if (list.size == 0) {
            throw new RuntimeException("Stack is empty");
        } else {
            return list.removeFirst();
        }
    }

    T peek() {
        return list.first.element;
    }
    boolean isEmpty()
    {
        return list.isEmpty();
    }
    Stack<T> reversedStack()
    { Stack<T> S2 = new Stack<T>();
      Stack<T> temp = new Stack<T>();
      while(!isEmpty())
      { T e = pop();
        S2.push(e);
        temp.push(e);
      }
      while(!temp.isEmpty())
      { T e = temp.pop();
        push(e);
      }
        return S2;
    }

      Stack<T> copyStack()
      { Stack<T> rvStack = reversedStack();
        return rvStack.reversedStack();

     }


    void printVertical() {
        list.printVertical();
    }

    static void binaryConversion(int x) {

        Stack<Integer> answer = new Stack<Integer>();

        if (x==0){
            answer.push(0);
        }
        int r;       //remainder
        while (x >  0) {
            r = x % 2;
            x = x / 2;
            answer.push(r);
        }
        answer.printVertical();
    }
    static boolean isPalindrome(String word)
    {  Stack<Character> S1 = new Stack<Character>();
       for(int i=0; i<word.length(); i++)
           S1.push(word.charAt(i));
       Stack<Character> S2 = S1.reversedStack();
       while(!S1.isEmpty())
       {
           if (!S1.pop().equals(S2.pop()))
               return false;

        }
       return true;

    }



    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int evalPostfix(String[] input) {
        Stack<Integer> S = new Stack<Integer>();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
            if (isInteger(input[i])) {
                S.push(Integer.parseInt(input[i]));
            } else {
                int y =  S.pop() ;
                int x =  S.pop() ;
                if (input[i].equals("+")) {
                    S.push( x + y);
                    // S.printVertical();
                } else if (input[i].equals("-")) {
                    S.push( x - y );
                    //  S.printVertical();
                } else if (input[i].equals("*")) {
                    S.push(  x * y );
                    //  S.printVertical();
                } else if (input[i].equals("/")) {
                    S.push( x / y );
                    //   S.printVertical();
                } else if (input[i].equals("%")) {
                    S.push( x % y );
                    //  S.printVertical();
                }
            }
        }
        System.out.println();
        return S.pop();
    }

     static boolean checkMatch(String a, String b)
    {  if((a == "{" && b == "}")||(a == "}" && b == "{") ||
               (a == "[" && b == "]") || (a == "]" && b == "[") ||
               (a == "(" && b == ")") || (a == ")" && b == "(") )
         return true;
       else
         return false;
     }
   static boolean isOpenParen(String a)
   { if(a=="{" || a=="[" || a=="("   )
       return true;
     else
       return false;
   }
   static boolean isCloseParen(String a)
   { if(a=="}" || a=="]" || a==")"   )
       return true;
     else
       return false;
   }

  static boolean ParenMatch(String [] Exp)
     {
       Stack<String> D = new Stack<String>();
       for(int i=0; i<Exp.length; i++)
       {  if(isOpenParen(Exp[i])==true)
              D.push(Exp[i]);
          else if(isCloseParen(Exp[i])==true)
           { if(D.isEmpty())
                return false;
             else if(checkMatch(D.pop(), Exp[i])==false)
                 return false;
          }
       }
       return D.isEmpty();
     }

}


 class TestStack {

    public static void main(String[] args) {

	//============================ Ex.1(a) ============================
		//Uncomment this part of code to test your result in Ex.1(a)
                System.out.println("***Testing Push for Ex1a***");
		Stack<Integer> S= new Stack<Integer>();
		S.push(2);
		S.push(5);
		S.push(7);
		S.push(1);
                System.out.println("Your result is : ");
		S.printVertical();
		System.out.println("The result should be : ");
		System.out.println("1");
		System.out.println("7");
		System.out.println("5");
		System.out.println("2");

		//============================ Ex.1(b) ============================
                 //continue from the previous exercise
                 //uncomment the lines below
                 System.out.println("\n***Testing Pop for Ex1b***");
                 S.pop();
                 S.pop();
                 System.out.println("Your result is : ");
                 S.printVertical();
                 System.out.println("The result should be : ");
                 System.out.println("5");
		 System.out.println("2");

		//============================ Ex.1(c) ============================
                 //continue from the previous exercise
                 //uncomment the lines below
	         System.out.println("\n***Testing Peek for Ex1c***");
                 System.out.println("Your result is : ");
                 System.out.println(S.peek());
                 System.out.println("The result should be : ");
                 System.out.println("5");


         System.out.println("----------------Ex2: Binary Conversion------------");
         //You may comment previous testing of Ex1
        System.out.println("Finding the binary value of 19 ");
        System.out.println("Your result is : ");
        Stack.binaryConversion(19);
        System.out.println("The correct answer should be :");
        System.out.println("1");
        System.out.println("0");
        System.out.println("0");
        System.out.println("1");
        System.out.println("1");

        System.out.println("Finding the binary value of 0");
        System.out.print("Your result is : ");
        Stack.binaryConversion(0);
        System.out.print ("The result should be : ");
        System.out.println("0");
        System.out.println();
          System.out.println("Finding the binary value of 1");
       System.out.print("Your result is : ");
        Stack.binaryConversion(1);
        System.out.print("The result should be : ");
        System.out.println("1");
         System.out.println();
		//============================ Ex.3a ============================
System.out.println("----------------Ex3 a: Inverse Stack------------");
Stack<Integer> S2 = new Stack<Integer>();
for(int i=9;i>5;i--)
    S2.push(i);
System.out.println("Original Stack ");
S2.printVertical();
System.out.println("After Reverse ");
Stack<Integer> rvS2 = S2.reversedStack();
System.out.println("Your result is : ");
rvS2.printVertical();
 System.out.println("The result should be : ");
 System.out.println("9");
 System.out.println("8");
 System.out.println("7");
 System.out.println("6");
		//============================ Ex.3b ============================
 System.out.println("----------------Ex3 b: isPalindrome------------");
 String word1 = "gatemannametag";
 String word2 = "";
  String word3 = "12340321";
 System.out.print(word1 + " is ");
 if(!Stack.isPalindrome(word1))
     System.out.print(" not ");
System.out.println("a palindrome.");

 System.out.print(word2 + " is ");
 if(!Stack.isPalindrome(word1))
     System.out.print(" not ");
System.out.println("a palindrome.");

 System.out.print(word3 + " is ");
 if(!Stack.isPalindrome(word3))
     System.out.print(" not ");
System.out.println("a palindrome.");



		//============================ Ex.4 ============================
  System.out.println("----------------Ex4: PostfixEvaluation ------------");
        String[] postfix = {"2","4","6","+","*"} ;
        String[] postfix1 = {"2"} ;
       int answer = Stack.evalPostfix(postfix);
        System.out.println("The answer is : "+answer);
        int answer1 = Stack.evalPostfix(postfix1);
        System.out.println("The answer is : "+answer1);

		//============================ Ex.5 ============================
     System.out.println("----------------Ex5: ParenMatch ------------");
       String [] exp1 = {")","1", "+", "2", "(", "3", "+", "2", ")", "[", "7", "/", "2", "]"};
       System.out.print("Exp1= ");
       for(int i=0; i<exp1.length; i++)
           System.out.print(exp1[i]);
       System.out.println();
       if(Stack.ParenMatch(exp1)==true)
           System.out.println("Your Result: All grouping symbols match in exp1");
       else
           System.out.println("Your Result: Grouping symbols do not match in exp1");
      System.out.println("The result should be : Grouping symbols do not match in exp1");
      System.out.println();

       String [] exp2 = { "(" , "1", "+", "2", "{", "(", "5", "/", "3", ")", "}" };
       System.out.print("Exp2= ");
       for(int i=0; i<exp2.length; i++)
           System.out.print(exp2[i]);
       System.out.println();
       if(Stack.ParenMatch(exp2)==true)
           System.out.println("Your Result: All grouping symbols match in exp2");
       else
           System.out.println("Your Result: Grouping symbols do not match in exp2");
      System.out.println("The result should be : Grouping symbols do not match in exp2");
      System.out.println();

      String [] exp3 = { "(" , "1", "+", "2", "{", ")", "5", "/", "3", "}" };
       System.out.print("Exp3= ");
       for(int i=0; i<exp3.length; i++)
           System.out.print(exp3[i]);
       System.out.println();
       if(Stack.ParenMatch(exp3)==true)
           System.out.println("Your Result: All grouping symbols match in exp3");
       else
           System.out.println("Your Result: Grouping symbols do not match in exp3");
      System.out.println("The result should be : Grouping symbols do not match in exp3");
      System.out.println();

      String [] exp4 = {"{",  "(" , "1", "/", "2", ")","-", "5", "+", "3", "}" };
             System.out.print("Exp4= ");
       for(int i=0; i<exp4.length; i++)
           System.out.print(exp4[i]);
       System.out.println();
       if(Stack.ParenMatch(exp4)==true)
           System.out.println("Your Result: All grouping symbols match in exp4");
       else
           System.out.println("Your Result: Grouping symbols do not match in exp4");
      System.out.println("The result should be : All grouping symbols match in exp4");

    }
}

