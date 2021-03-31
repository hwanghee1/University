#include<stdio.h>
#include<stdlib.h>
#define FALSE 0
#define TRUE	1
#define MAX_VERTICES 8
short int visited[MAX_VERTICES];

void init_visited() {
	for (int i = 0; i < MAX_VERTICES; i++)
		visited[i] = FALSE;
}

typedef struct queue *queue_pointer;
typedef struct queue {
	int vertex;
	queue_pointer link;
};

typedef struct node {
	int vertex;
	struct node * link;
}NODE;

NODE * graph[MAX_VERTICES];
// 연결리스트 추가함수
int stack[100];
int top = -1;

void push(int v) {
	if (top < 99)
		stack[++top] = v;
	else {
		printf("stack is full\n");
		return;
	}

}
int stack_empty() {
	if (top < 0)
		return 1;
	else
		return 0;
}
int pop() {
	if (stack_empty())
		return -1;
	else {
		return stack[top--];
	}
}
void AddNode(NODE ** head, int data) {
	NODE * p = *head;
	NODE * temp = (NODE*)malloc(sizeof(NODE));
	temp->link = NULL;
	temp->vertex = data;

	if (*head == NULL) {
		*head = temp;
		return;
	}

	while (p->link) {
		p = p->link;
	}
	p->link = temp;
}

void addq(queue_pointer *front, queue_pointer *rear, int v) {
	queue_pointer p = *front;
	queue_pointer temp = (queue_pointer)malloc(sizeof(queue_pointer));
	temp->link = NULL;
	temp->vertex = v;

	if (*front == NULL) {
		*front = temp;
		*rear = temp;
		return;
	}
	while (p->link) {
		p = p->link;
	}
	p->link = temp;
	*rear = temp;
}
int deleteq(queue_pointer *front) {
	queue_pointer p = *front;
	int v = p->vertex;
	*front = p->link;
	return v;
}
void bfs(int v)
{
	init_visited();

	// Vertex v부터 탐색 수행. visited[] 배열은 FALSE로 초기화. 큐를 사용
	NODE * w;
	queue_pointer front = NULL, rear = NULL;

	printf("\n-------------- result of bfs() --------------\n");
	printf("%5d", v);
	visited[v] = TRUE;
	addq(&front, &rear, v);
	//addq 구현하기
	while (front) {
		v = deleteq(&front);
		for (w = graph[v]; w; w = w->link)
			if (!visited[w->vertex]) {
				printf("%5d", w->vertex);
				addq(&front, &rear, w->vertex);
				visited[w->vertex] = TRUE;
			}
	}
	printf("\n---------------------------------------------\n");
}
void stack_dfs(int v)
{
	printf("\n----------- result of stack dfs() -----------\n");
	init_visited();
	int vertex_exist = FALSE;
	NODE * w;
	push(v);
	visited[v] = TRUE;
	printf("%5d", v);

	while (!stack_empty()) {
		w = graph[v];
		while (1) {
			if (!visited[w->vertex]) {
				vertex_exist = TRUE;
				break;
			}
			else {
				if (!w->link)
					break;
				w = w->link;
			}
		}
		if (vertex_exist) {
			visited[w->vertex] = TRUE;
			printf("%5d", w->vertex);
			if (!w->link) {
				v = pop();
				continue;
			}
			push(w->vertex);
			v = w->vertex;
		}
		else {
			v = pop();
		}
		vertex_exist = FALSE;
	}
	printf("\n---------------------------------------------\n");
}
void dfs(int v)
{
	NODE * w;
	visited[v] = TRUE;
	printf("%5d", v);
	for (w = graph[v]; w; w = w->link)
		if (!visited[w->vertex]) dfs(w->vertex);
}
void print_dfs(int v) {
	init_visited();
	printf("\n-------------- result of dfs() --------------\n");
	dfs(0);
	printf("\n---------------------------------------------\n");
}

int main() {
	AddNode(&graph[0], 1);
	AddNode(&graph[0], 2);

	AddNode(&graph[1], 0);
	AddNode(&graph[1], 3);
	AddNode(&graph[1], 4);

	AddNode(&graph[2], 0);
	AddNode(&graph[2], 5);
	AddNode(&graph[2], 6);

	AddNode(&graph[3], 1);
	AddNode(&graph[3], 7);

	AddNode(&graph[4], 1);
	AddNode(&graph[4], 7);

	AddNode(&graph[5], 2);
	AddNode(&graph[5], 7);

	AddNode(&graph[6], 2);
	AddNode(&graph[6], 7);

	print_dfs(0);
	stack_dfs(0);
	bfs(0);
	

	printf("\n");
}