/**************************************************************/
/*
Patrick Flaherty
Euler 4: Largest PalinDromic Product

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.


*/

#include <stdio.h>
#include<stdlib.h>
#include <inttypes.h>
#include <arpa/inet.h>
#include <string.h>
#include "CPU.h"

int main(int argc, char **argv)
{
  int a, b, c; //a * b = c
  int back, front; //front and back most integers that we are comparing
  int currBiggest = 0; //We may want to compare one C with a previous C we have caluclated
  int done = 0;

  while(!done){
    b = a; //init b to a on the start of each new int a so that we do not repeat calculations
    while(b-99){ //if b ever equals 99 we will break from the loop
      c = a*b; //set c

    }
    a--; //subtract one from a and continue
  }
  a = 999;


}
