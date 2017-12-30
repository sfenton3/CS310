#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define MILLION 1000000L

unsigned N;
char P[27];
unsigned table[12][12] =
  { {0}, {0, 1}, {0, 1, 1}, {0, 1, 2, 3},
    {0, 3, 1, 3, 1},
    {0, 3, 4, 3, 2, 3},
    {0, 5, 3, 1, 5, 3, 1},
    {0, 5, 2, 7, 2, 1, 2, 3},
    {0, 7, 1, 5, 5, 3, 3, 7, 1},
    {0, 7, 8, 1, 6, 5, 4, 9, 2, 3},
    {0, 9, 7, 5, 3, 1, 9, 7, 5, 3, 1},
    {0, 9, 6, 3, 10, 9, 4, 3, 8, 9, 2, 3}};

void init(void){
  unsigned i;

  P[0] = '*';
  for (i=0; i<26; i++)
    P[i+1] = 'A' + i;
}

inline void swap(unsigned i, unsigned j){
  char c;

  c = P[i];
  P[i] = P[j];
  P[j] = c;
}

void printIt(void){
  static unsigned long count = 0;

  //to compare performance, comment out from here
  //unsigned i;

  //for (i=1; i<=N; i++)
   // printf("%c", P[i]);
  //printf("\n");
  //to here

  count++;
}

void permute1(unsigned n){
  unsigned i;

  if (n == 1)
    printIt();
  for (i=1; i<=n; i++){
    swap(i, n);
    permute1(n-1);
    swap(i, n);
  }
}

void permute2(unsigned n){
  unsigned i;

  if (n == 1){
    printIt();
    return;
  }
  for (i=1; i<=n; i++){
    permute2(n - 1);
    swap(table[n][i], n);
  }
}

void permute3(unsigned n){
  unsigned i;

  if (n == 1){
    printIt();
    return;
  }
  for (i=1; i<=n; i++){
    permute3(n - 1);
    swap((n & 0x01) ? 1 : i, n);
  }
}

void (*algPtr[4])(unsigned) = {NULL, permute1, permute2, permute3};

int main(int argc, char *argv[]){
  unsigned alg;
  int c;

  N = 4;
  alg = 1;
  while ((c = getopt(argc, argv, "a:n:")) != -1){
    switch (c){
    case 'a': sscanf(optarg, "%u", &alg); break;
    case 'n': sscanf(optarg, "%u", &N); break;
    default: break;
    }
  }
  N = ((N < 2) || (N > 12)) ? 4 : N;
  alg = ((alg < 1) || (alg > 3)) ? 1 : alg;

  init();

  struct timeval start, stop;
  float sec;

  gettimeofday(&start, NULL);
  algPtr[alg](N);
  gettimeofday(&stop, NULL);

  sec = (stop.tv_sec - start.tv_sec) +
    (stop.tv_usec - start.tv_usec) / (float)MILLION;
  printf("permute%1d, N = %u, %.6f\n", alg, N, sec);

  return 0;
}
