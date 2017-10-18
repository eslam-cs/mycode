/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.util.Arrays;

/**
 *
 * @author 7
 */


public class des1 {
    
    @SuppressWarnings("empty-statement")
    public static int [] plain_IP = new int[64];
    public static int [] R0 = new int[32];
    public static int [] L0 = new int[32];
    public static int [] R0e =new int[48];
    public static int [] k0 = new int [56];
    public static int [] c0 = new int[28];
    public static int [] d0 = new int[28];
    public static int [] k0cd=new int [56];
    public static int [] k1= new int [48]; 
    public static int [] func = new int [48];
    public static int [] sbox = new int [32];
    public static int [] cf = new int [32];
    public static int [] L1=new int[32];
    public static int [] R1=new int [32];
    public static int xor (int x,int y)
        {
            int z;
            
            if(x==y)
            {z=0;}
            else
            {z=1;}
            
            return z;
        }
    public static void IP(int [] plain_text)
    {
                int[] IP = {
                    58, 50, 42, 34, 26, 18, 10, 2,
                    60, 52, 44, 36, 28, 20, 12, 4,
                    62, 54, 46, 38, 30, 22, 14, 6,
                    64, 56, 48, 40, 32, 24, 16, 8,
                    57, 49, 41, 33, 25, 17,  9, 1,
                    59, 51, 43, 35, 27, 19, 11, 3,
                    61, 53, 45, 37, 29, 21, 13, 5,
                    63, 55, 47, 39, 31, 23, 15, 7
                    };
        
        
        
        for(int i=0;i<IP.length;i++) //create R after IP & L0 & R0 
        {
            int x = IP[i]-1;
            plain_IP[i]= plain_text[x];
            if(i<32)
            {
                L0[i]=plain_IP[i];
                    }
            else
            {
                R0[i-32]=plain_IP[i];
            }
            //System.out.print( plain_IP[i]);
         
        }
        
       // System.out.println();
        /*   
        System.out.print("R0 = ");   
        for(int i=0;i<R0.length;i++)
        {
            System.out.print(R0[i]);
        }
        
        System.out.println();
        
        System.out.print("L0 = ");    
        for(int i=0;i<L0.length;i++)
        {
            System.out.print(L0[i]);
        }   
        System.out.println();
                */
    }
    public static void ebit()
    {
                        int [] ebit = {
                        32,  1,  2,  3,  4,  5,
                         4,  5,  6,  7,  8,  9,
                         8,  9, 10, 11, 12, 13,
                        12, 13, 14, 15, 16, 17,
                        16, 17, 18, 19, 20, 21,
                        20, 21, 22, 23, 24, 25,
                        24, 25, 26, 27, 28, 29,
                        28, 29, 30, 31, 32,  1
                        };
        
        
       // System.out.print("R0-Ebit = "); //create R0 with E-bit
        for(int i =0;i<48;i++)
        {
            R0e[i]= R0[ebit[i]-1];
            //System.out.print( R0e[i]);
        }
       // System.out.println();
        
    }
    
    public static void  pc1 (int [] key)
    {
                int [] pc1 = {
                        57,   49,    41,   33,    25,    17,    9,
                         1,   58,    50,   42,    34,    26,   18,
                        10,    2,    59,   51,    43,    35,   27,
                        19,   11,     3,   60,    52,    44,   36,
                        63,   55,    47,   39,    31,    23,   15,
                         7,   62,    54,   46,    38,    30,   22,
                        14,    6,    61,   53,    45,    37,   29,
                        21,   13,     5,   28,    20,    12,    4
                        };
        
      
        
        //System.out.print("k0-pc1 = "); //create K0 after PC-1
        for(int i=0;i<56;i++)
        {
            k0[i]=key[pc1[i]-1];
          //  System.out.print(k0[i]);
                  
        }
        //System.out.println();
        
      
    }    
    
    public static void CD()
    {
           for(int i=0;i<k0.length;i++) //c0 & d0 
        {

            
            if(i<28)
            {
                c0[i]=k0[i];
                    }
            else
            {
                d0[i-28]=k0[i];
            }
        }
        
        
       // System.out.print("C0 = ");   
        for(int i=0;i<c0.length;i++)
        {
           // System.out.print(c0[i]);
        }
        
       // System.out.println();   
        
      //  System.out.print("D0 = ");   
        for(int i=0;i<c0.length;i++)
        {
          //  System.out.print(d0[i]);
        }
        
       // System.out.println(); 
    }
    
    public static void shift()
    {
        int cup;
        for(int i =0 ;i<c0.length-1;i++)
        {
            cup=c0[i];
            c0[i]=c0[i+1];
            c0[i+1]=cup;
        }
       // System.out.print("C0 after shift = ");   
        for(int i=0;i<c0.length;i++)
        {
        //    System.out.print(c0[i]);
        }
        
       // System.out.println();   
        
        for(int i =0 ;i<d0.length-1;i++)
        {
            cup=d0[i];
            d0[i]=d0[i+1];
            d0[i+1]=cup;
        }
        /*
        System.out.print("D0 after shift = ");   
        for(int i=0;i<d0.length;i++)
        {
            System.out.print(d0[i]);
        }
        
        System.out.println();  */ 
    }
    
    
    public static void key()
    {
        //System.out.print("k0 after C & D = ");
        for(int i =0;i<56;i++)
        {
            if(i<28)
            {
                k0cd[i]=c0[i];
            }
            else
            {
                k0cd[i]=d0[i-28];
            }
            
           // System.out.print(k0cd[i]);
        }
       // System.out.println();  
    }
    
    public static void pc2()
    {
        int [] pc2 = {
                       14,    17,   11,    24,     1,    5,
                        3,    28,   15,     6,    21,   10,
                       23,    19,   12,     4,    26,    8,
                       16,     7,   27,    20,    13,    2,
                       41,    52,   31,    37,    47,   55,
                       30,    40,   51,    45,    33,   48,
                       44,    49,   39,    56,    34,   53,
                       46,    42,   50,    36,    29,   32
                        };
       
        
       System.out.print("k = ");
        for(int i =0;i<48;i++)
        {
            k1[i]=k0cd[pc2[i]-1];
            System.out.print(k1[i]);
        }
       System.out.println();
    }
    
    public static void sbox()
    {
                int [][] s1 = {
                        {14,  4,  13,  1,   2, 15,  11,  8,   3, 10,   6, 12,   5,  9,   0,  7},
                        { 0, 15,   7,  4,  14,  2,  13,  1,  10,  6,  12, 11,   9,  5,   3,  8},
                        { 4,  1,  14,  8,  13,  6,   2, 11,  15, 12,   9,  7,   3, 10,   5,  0},
                        {15, 12,   8,  2,   4,  9,   1,  7,   5, 11,   3, 14,  10,  0,   6, 13},
                        
                        {15,  1,   8, 14,   6, 11,   3,  4,   9,  7,   2, 13,  12,  0,   5, 10},
                        { 3, 13,   4,  7,  15,  2,   8, 14,  12,  0,   1, 10,   6,  9,  11,  5},
                        { 0, 14,   7, 11,  10,  4,  13,  1,   5,  8,  12,  6,   9,  3,   2, 15},
                        {13,  8,  10,  1,   3, 15,   4,  2,  11,  6,   7, 12,   0,  5,  14,  9},
        
                        {10,  0,   9, 14,   6,  3,  15,  5,   1, 13,  12,  7,  11,  4,   2,  8},
                        {13,  7,   0,  9,   3,  4,   6, 10,   2,  8,   5, 14,  12, 11,  15,  1},
                        {13,  6,   4,  9,   8, 15,   3,  0,  11,  1,   2, 12,   5, 10,  14,  7},
                        { 1, 10,  13,  0,   6,  9,   8,  7,   4, 15,  14,  3,  11,  5,   2, 12},
        
                        { 7, 13,  14,  3,   0,  6,   9, 10,   1,  2,   8,  5,  11, 12,   4, 15},
                        {13,  8,  11,  5,   6, 15,   0,  3,   4,  7,   2, 12,   1, 10,  14,  9},
                        {10,  6,   9,  0,  12, 11,   7, 13,  15,  1,   3, 14,   5,  2,   8,  4},
                        { 3, 15,   0,  6,  10,  1,  13,  8,   9,  4,   5, 11,  12,  7,   2, 14},
        
                        { 2, 12,   4,  1,   7, 10,  11,  6,   8,  5,   3, 15,  13,  0,  14,  9},
                        {14, 11,   2, 12,   4,  7,  13,  1,   5,  0,  15, 10,   3,  9,   8,  6},
                        { 4,  2,   1, 11,  10, 13,   7,  8,  15,  9,  12,  5,   6,  3,   0, 14},
                        {11,  8,  12,  7,   1, 14,   2, 13,   6, 15,   0,  9,  10,  4,   5,  3},
        
                        {12,  1,  10, 15,   9,  2,   6,  8,   0, 13,   3,  4,  14,  7,   5, 11},
                        {10, 15,   4,  2,   7, 12,   9,  5,   6,  1,  13, 14,   0, 11,   3,  8},
                        { 9, 14,  15,  5,   2,  8,  12,  3,   7,  0,   4, 10,   1, 13,  11,  6},
                        { 4,  3,   2, 12,   9,  5,  15, 10,  11, 14,   1,  7,   6,  0,   8, 13},

                        { 4, 11,   2, 14,  15,  0,   8, 13,   3, 12,   9,  7,   5, 10,   6,  1},
                        {13,  0,  11,  7,   4,  9,   1, 10,  14,  3,   5, 12,   2, 15,   8,  6},
                        { 1,  4,  11, 13,  12,  3,   7, 14,  10, 15,   6,  8,   0,  5,   9,  2},
                        { 6, 11,  13,  8,   1,  4,  10,  7,   9,  5,   0, 15,  14,  2,   3, 12},
        
                        {13,  2,   8,  4,   6, 15,  11,  1,  10,  9,   3, 14,   5,  0,  12,  7},
                        { 1, 15,  13,  8,  10,  3,   7,  4,  12,  5,   6, 11,   0, 14,   9,  2},
                        { 7, 11,   4,  1,   9, 12,  14,  2,   0,  6,  10, 13,  15,  3,   5,  8},
                        { 2,  1,  14,  7,   4, 10,   8, 13,  15, 12,   9,  0,   3,  5,   6, 11}
                    };
        
        
        String row = "",colm = "";
        String texts;
        texts = "";
        
        int res,rc;
        rc=0;
        for (int i=0; i<48;i=i+6)
        {
            row += String.valueOf(func[i]) + String.valueOf(func[i+5]);
           // System.out.println(row);
            colm += String.valueOf(func[i+1]) + String.valueOf(func[i+2]) + String.valueOf(func[i+3]) + String.valueOf(func[i+4]);
           // System.out.println(colm);
            
            int rown,colmn;
            
            rown=Integer.parseInt(row, 2);
            colmn=Integer.parseInt(colm, 2);
            
           
            res= s1[rown+rc][colmn];
            //System.out.println(res);
            rc=rc+4;
            String z ;
            z=Integer.toBinaryString(res);
            
            for(int j =0;j<4;j++){
                    if (z.length()<4)
                            {z="0"+z;}
            }
            
            texts = texts + z ;
            
            
            
            
            row = colm = "";
            
            
        }
        
        for(int i=0;i<32;i++)
        {
            sbox[i]=(int) texts.charAt(i)-48;
        }
        //System.out.print("S-box = ");
       // System.out.println(texts);
    }
    
    public static void P()
    {
        
        int [] p = {
                         16,   7,  20,  21,
                         29,  12,  28,  17,
                          1,  15,  23,  26,
                          5,  18,  31,  10,
                          2,   8,  24,  14,
                         32,  27,   3,   9,
                         19,  13,  30,   6,
                         22,  11,   4,  25
                        };
        
        
        
       // System.out.print("C = ");
        for(int i =0;i<32;i++)
        {
            cf[i]=sbox[p[i]-1];
         //   System.out.print( cf[i]);
        }
       // System.out.println();
    }
    
    
    
    
    
    
    public static void main(String[] args) {
    
        int[] plain_text = {0,0,0,0,0,0,0,1,
                            0,0,1,0,0,0,1,1,
                            0,1,0,0,0,1,0,1,
                            0,1,1,0,0,1,1,1,
                            1,0,0,0,1,0,0,1,
                            1,0,1,0,1,0,1,1,
                            1,1,0,0,1,1,0,1,
                            1,1,1,0,1,1,1,1};
        int[] key = {0,0,0,1,0,0,1,1,0,0,
                      1,1,0,1,0,0,0,1,0,1,
                      0,1,1,1,0,1,1,1,1,0,
                      0,1,1,0,0,1,1,0,1,1,
                      1,0,1,1,1,1,0,0,1,1,
                      0,1,1,1,1,1,1,1,1,1,
                      0,0,0,1};
/////////////////////////pc1//////////////////////////////////////////////////////////        
        pc1(key);
 ///////////////////////////////////////////c0,d0////////////////////////////////////////////       
        CD();
        
////////////////////////////////////////////////////////////////////
        IP(plain_text);
        
        //***************
        for (int z=0; z<16;z++){

//////////////////////////////////////ebit///////////////////////////////////////////////        
        ebit();
///////////////////////////////////////c-d///////////////////////////////////////////// 
        if(z==0 || z==1 || z==8 || z==15)
        {
        shift();
        }
        else
        {
        shift();
        shift();
        }
        key(); 
/////////////////////////////////////pc-2/////////////////////////////////////////////
        pc2(); 
//////////////////////////////////function xor////////////////////////////////////////////////        
        
        //System.out.print("K1+E(R0) = ");
        for(int i=0;i<48;i++)
        {
            func[i] = xor(R0e[i],k1[i]);
           // System.out.print(func[i]);
            
        }
        //System.out.println();
        
////////////////////////////////////s-box/////////////////////////////////////////////        
       sbox(); 
/////////////////////////////P  permutation  C//////////////////////////////////////
       P(); 
////////////////////////////////////////R1 & L1//////////////////////////////////////        
        
        L1=R0;
        
        System.out.print("L"+(z+1)+" = ");    
        for(int i=0;i<L1.length;i++)
        {
            System.out.print(L1[i]);
        }   
        System.out.println();
        
        
        System.out.print("R"+(z+1)+" = ");
        for(int i =0;i<32;i++)
        {
            
            R1[i] = xor(L0[i],cf[i]);
            System.out.print(R1[i]);
        
        }
        System.out.println();
        
//////////////finch  //////////////////////////////////////////////////////////////////
        
      R0=R1;
      L0=L1;
  }
 }
}