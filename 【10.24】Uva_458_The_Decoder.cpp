#include <cstdio>
#include <cstdlib>
#include <cstring>

int main(){
	char input[300];
	while(gets(input) != NULL){
		if(strcmp(input, "") == 0) break;
		int i;
		for(i = 0; input[i] != '\0'; i++){
			printf("%c", input[i] - 7);
		}
		printf("\n");
	}
	strncmp()
	return 0;
}
