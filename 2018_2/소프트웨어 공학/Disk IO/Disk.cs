using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Disk_IO
{
    class Disk
    {
        Queue<int> DiskQueue;


        public Disk()
        {
            this.DiskQueue = new Queue<int>();

        }

        public void EnqueueDiskQ(string args)
        { 
            foreach (string tmp in args.Split(','))
            {
                this.DiskQueue.Enqueue(int.Parse(tmp));
            }
        }

        public void Clean()
        {
            this.DiskQueue.Clear();
            Tracer.counter = 0;
        }

        public List<Tracer> SchedulingWithFCFS(int intialPoint)
        {
            List<Tracer> tr = new List<Tracer>();
            int acc = 0;
            int currentCur = intialPoint;
            int movement = 0;

            tr.Add(new Tracer(currentCur, 0, 0));

            while (this.DiskQueue.Count > 0 )
            {
                int nextCur = this.DiskQueue.Dequeue();
                movement = nextCur - currentCur;
                acc = acc + Math.Abs(movement);
                currentCur = nextCur;
                tr.Add(new Tracer(currentCur, movement, acc));
            }

            return tr;
        }
        public List<Tracer> SchedulingWithSCAN(int intialPoint) // SCAN스케쥴링 함수
        {
            List<Tracer> tr = new List<Tracer>();
            List<int> diff = new List<int>(); // 현재 head위치와 가장 가까운 실린더를 찾기 위해 필요한 리스트
                                       //(초기 head위치와 queue내의 실린더 간 거리)
            List<int> lst = new List<int>(); // 실린더 작업순서 정렬을 위한 임시 리스트(정렬된 리스트)
            int i = 0; // diff의 인덱스 변수
            int index = 0; // SCAN의 방향을 정하기 위해 diff 리스트 내 head위치와 가장 가까운 수의 인덱스를 저장할 변수
            int diff_min = intialPoint; // head위치와 가장 가까운 거리를 저장할 변수
            int acc = 0; // 총 이동거리를 저장할 변수
            int currentCur = intialPoint; // 현재 head위치
            int movement = 0; // 현재 head위치와 다음 head위치의 거리
                       
            tr.Add(new Tracer(currentCur, 0, 0)); // Tracer객체 초기화
            diff.Add(diff_min); // diff리스트 초기화
            lst.Add(intialPoint); // lst리스트 초기화

            while ( this.DiskQueue.Count > 0) // DiskQueue 큐에 들어간 실린더 위치를 모두 빼낼때 까지 반복
            {
                lst.Add(this.DiskQueue.Dequeue()); // DiskQueue에 무작위 수로 이루어진 큐를 빼내 lst에 추가
                diff.Add(Math.Abs(lst[i]-currentCur)); // 현재 위치와 각 실린더 위치와의 거리를 diff 리스트에 추가
                if (diff_min > diff[i]) // 가장 가까운 거리의 실린더 위치를 찾기위한 if문
                {
                    index = i;   // 가장 가까운 거리의 실린더 위치가 있는 인덱스를 index변수에 저장                
                }                                         
                i++;
            }
            diff_min = lst[index]; // 정렬된 lst리스트에서 가장 가까운 실린더를 찾기 위해 diff_min에 lst[index]값 저장
            int tmp;
            for(i = 0; i < lst.Count-1; i++) // lst정렬
            {
                for(int j = i + 1; j < lst.Count; j++)
                {
                    if (lst[i] > lst[j]){
                        tmp = lst[i];
                        lst[i] = lst[j];
                        lst[j] = tmp;
                    }
                }
            }
            int res_index = -1, init_index = -1; // res_index -> 가장 가까운 실린더의 인덱스
                                           // init_index -> head가 있는 실린더의 인덱스
            int fin_index = lst.Count;          // fin_index -> lst배열의 끝+1의 인덱스
            for (i = 0; i < lst.Count; i++) // 미리 저장해둔 diff_min과 initialPoint의 위치를 정렬된 lst안에서 찾기위한 반복문
            {
                if (diff_min == lst[i])
                    res_index = i;
                else if (intialPoint == lst[i])
                    init_index = i;
            }
            this.DiskQueue.Clear(); // DiskQueue 비움(초기상태에서 다시 채워넣기 위함)
            if (res_index > init_index) // head의 이동방향(왼쪽 or 오른쪽)을 정하기 위한 if문
            {                      // 가장 가까운거리의 실린더가 head보다 오른쪽에 있는 경우
                for (int j = init_index+1; j < lst.Count; j++) // 초기 head위치보다 오른쪽에 있는 실린더 위치를
                {
                    this.DiskQueue.Enqueue(lst[j]); // DiskQueue에 모두 넣어준다.
                }
                if (lst.IndexOf(400) == -1)     // 무작위로 수를 생성 했을 때, 오른쪽 끝 수인 400이 생성될 가능성이 있으므로
                    this.DiskQueue.Enqueue(400); // 큐 내에 400이 존재하지 않을 때 400을 큐에 넣는다.(가장자리를 찍어야하는 SCAN의 특성)
                for(int k = init_index-1; k > -1; k--) // SCAN 스케쥴링이므로 끝을 찍고 돌아오는 방향에 있는 작업을 모두 수행해 주어야한다.
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            else  // 가장 가까운 실린더가 head보다 왼쪽에 있는 경우
            {
                for(int j = init_index-1; j > -1; j--) // head가 실린더 위치(0~400)중 작은쪽(0)으로 움직이므로
                {
                    this.DiskQueue.Enqueue(lst[j]); // DiskQueue에 초기 head위치보다 왼쪽의 실린더를 넣어준다.
                }
                if(lst.IndexOf(0)==-1) // 무작위로 수를 생성 했을 때, 왼쪽의 끝 수인 0이 생성될 가능성이 있음.
                    this.DiskQueue.Enqueue(0); // 큐 내에 0이 존재하지 않을 때 0을 큐에 넣는다.
                for(int k = init_index + 1; k < fin_index; k++) // 초기 head위치보다 오른쪽의 실린더를 모두 큐에 넣어준다.
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            while (this.DiskQueue.Count > 0) // 큐에 담긴 실린더 위치를 꺼내주며 이동거리를 계산한다.
            {
                int nextCur = this.DiskQueue.Dequeue();
                movement = nextCur - currentCur;
                acc = acc + Math.Abs(movement);
                currentCur = nextCur;
                tr.Add(new Tracer(currentCur, movement, acc));
            }

                return tr;
        }
        public List<Tracer> SchedulingWithLOOK(int intialPoint) //LOOK 스케쥴링 함수
        {
            List<Tracer> tr = new List<Tracer>();
            List<int> diff = new List<int>(); // 현재 head위치와 가장 가까운 실린더를 찾기 위해 필요한 리스트
                                              //(초기 head위치와 queue내의 실린더 간 거리)
            List<int> lst = new List<int>(); // 실린더 작업순서 정렬을 위한 임시 리스트(정렬된 리스트)
            int i = 0; // diff의 인덱스 변수
            int index = 0; // SCAN의 방향을 정하기 위해 diff 리스트 내 head위치와 가장 가까운 수의 인덱스를 저장할 변수
            int diff_min = intialPoint; // head위치와 가장 가까운 거리를 저장할 변수
            int acc = 0; // 총 이동거리를 저장할 변수
            int currentCur = intialPoint; // 현재 head위치
            int movement = 0; // 현재 head위치와 다음 head위치의 거리

            tr.Add(new Tracer(currentCur, 0, 0)); // Tracer객체 초기화
            diff.Add(diff_min); // diff리스트 초기화
            lst.Add(intialPoint); // lst리스트 초기화

            while (this.DiskQueue.Count > 0) // DiskQueue 큐에 들어간 실린더 위치를 모두 빼낼때 까지 반복
            {
                lst.Add(this.DiskQueue.Dequeue()); // DiskQueue에 무작위 수로 이루어진 큐를 빼내 lst에 추가
                diff.Add(Math.Abs(lst[i] - currentCur)); // 현재 위치와 각 실린더 위치와의 거리를 diff 리스트에 추가
                if (diff_min > diff[i]) // 가장 가까운 거리의 실린더 위치를 찾기위한 if문
                {
                    index = i;   // 가장 가까운 거리의 실린더 위치가 있는 인덱스를 index변수에 저장                
                }
                i++;
            }
            diff_min = lst[index]; // 정렬된 lst리스트에서 가장 가까운 실린더를 찾기 위해 diff_min에 lst[index]값 저장
            int tmp;
            for (i = 0; i < lst.Count - 1; i++) // lst정렬
            {
                for (int j = i + 1; j < lst.Count; j++)
                {
                    if (lst[i] > lst[j])
                    {
                        tmp = lst[i];
                        lst[i] = lst[j];
                        lst[j] = tmp;
                    }
                }
            }
            int res_index = -1, init_index = -1; // res_index -> 가장 가까운 실린더의 인덱스
                                                 // init_index -> head가 있는 실린더의 인덱스
            int fin_index = lst.Count;          // fin_index -> lst배열의 끝+1의 인덱스
            for (i = 0; i < lst.Count; i++) // 미리 저장해둔 diff_min과 initialPoint의 위치를 정렬된 lst안에서 찾기위한 반복문
            {
                if (diff_min == lst[i])
                    res_index = i;
                else if (intialPoint == lst[i])
                    init_index = i;
            }
            this.DiskQueue.Clear(); // DiskQueue 비움(초기상태에서 다시 채워넣기 위함)
            if (res_index > init_index) // SCAN과 알고리즘은 비슷하나 양 끝점을 큐에 넣지 않는다는 차이점이 있다.
            {
                for (int j = init_index + 1; j < lst.Count; j++)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }
                for (int k = init_index - 1; k > -1; k--)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            else
            {
                for (int j = init_index - 1; j > -1; j--)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }
                for (int k = init_index + 1; k < fin_index; k++)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            while (this.DiskQueue.Count > 0) // 큐에 담긴 실린더 위치를 꺼내주며 이동거리를 계산한다
            {
                int nextCur = this.DiskQueue.Dequeue();
                movement = nextCur - currentCur;
                acc = acc + Math.Abs(movement);
                currentCur = nextCur;
                tr.Add(new Tracer(currentCur, movement, acc));
            }

            return tr;
        }
        public List<Tracer> SchedulingWithC_SCAN(int intialPoint) // C-SCAN 스케쥴링 함수
        {
            List<Tracer> tr = new List<Tracer>();
            List<int> diff = new List<int>(); // 현재 head위치와 가장 가까운 실린더를 찾기 위해 필요한 리스트
                                              //(초기 head위치와 queue내의 실린더 간 거리)
            List<int> lst = new List<int>(); // 실린더 작업순서 정렬을 위한 임시 리스트(정렬된 리스트)
            int i = 0; // diff의 인덱스 변수
            int index = 0; // SCAN의 방향을 정하기 위해 diff 리스트 내 head위치와 가장 가까운 수의 인덱스를 저장할 변수
            int diff_min = intialPoint; // head위치와 가장 가까운 거리를 저장할 변수
            int acc = 0; // 총 이동거리를 저장할 변수
            int currentCur = intialPoint; // 현재 head위치
            int movement = 0; // 현재 head위치와 다음 head위치의 거리

            tr.Add(new Tracer(currentCur, 0, 0)); // Tracer객체 초기화
            diff.Add(diff_min); // diff리스트 초기화
            lst.Add(intialPoint); // lst리스트 초기화

            while (this.DiskQueue.Count > 0) // DiskQueue 큐에 들어간 실린더 위치를 모두 빼낼때 까지 반복
            {
                lst.Add(this.DiskQueue.Dequeue()); // DiskQueue에 무작위 수로 이루어진 큐를 빼내 lst에 추가
                diff.Add(Math.Abs(lst[i] - currentCur)); // 현재 위치와 각 실린더 위치와의 거리를 diff 리스트에 추가
                if (diff_min > diff[i]) // 가장 가까운 거리의 실린더 위치를 찾기위한 if문
                {
                    index = i;   // 가장 가까운 거리의 실린더 위치가 있는 인덱스를 index변수에 저장                
                }
                i++;
            }
            diff_min = lst[index]; // 정렬된 lst리스트에서 가장 가까운 실린더를 찾기 위해 diff_min에 lst[index]값 저장
            int tmp;
            for (i = 0; i < lst.Count - 1; i++) // lst정렬
            {
                for (int j = i + 1; j < lst.Count; j++)
                {
                    if (lst[i] > lst[j])
                    {
                        tmp = lst[i];
                        lst[i] = lst[j];
                        lst[j] = tmp;
                    }
                }
            }
            int res_index = -1, init_index = -1; // res_index -> 가장 가까운 실린더의 인덱스
                                                 // init_index -> head가 있는 실린더의 인덱스
            int fin_index = lst.Count;          // fin_index -> lst배열의 끝+1의 인덱스
            for (i = 0; i < lst.Count; i++) // 미리 저장해둔 diff_min과 initialPoint의 위치를 정렬된 lst안에서 찾기위한 반복문
            {
                if (diff_min == lst[i])
                    res_index = i;
                else if (intialPoint == lst[i])
                    init_index = i;
            }
            this.DiskQueue.Clear(); // DiskQueue 비움(초기상태에서 다시 채워넣기 위함)
            if (res_index > init_index) // SCAN스케쥴링 함수와 비슷한 알고리즘이나
            {                      // 양 끝과 끝이 연결 되어있는 것으로 생각하여
                                  // 양 끝점(0,400)을 추가해주는 구문이 추가 됨
                for (int j = init_index + 1; j < lst.Count; j++)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }
                if (lst.IndexOf(400) == -1)
                    this.DiskQueue.Enqueue(400);
                if (lst.IndexOf(0) == -1)
                    this.DiskQueue.Enqueue(0);
                for (int k = 0; k < init_index; k++)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            else
            {
                for (int j = init_index - 1; j > -1; j--)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }
                if (lst.IndexOf(0) == -1)
                    this.DiskQueue.Enqueue(0);
                if (lst.IndexOf(400) == -1)
                    this.DiskQueue.Enqueue(400);
                for (int k = fin_index -1; k > init_index; k--)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            while (this.DiskQueue.Count > 0) // 큐에 담긴 실린더 위치를 꺼내주며 이동거리를 계산한다
            {
                int nextCur = this.DiskQueue.Dequeue();
                if ((nextCur == 0 && currentCur==400)|| (nextCur == 400 && currentCur == 0))
                {                   // 디스크의 시작 = 0, 끝 = 400 이고 Circular를 생각하는 스케쥴링이므로
                    movement = 0;  // Circular의 특성으로 인해 400 -> 0 으로 가는 이동거리는 생각하지 않는다.
                }               
                else
                {
                    movement = nextCur - currentCur;
                }
                acc = acc + Math.Abs(movement);
                currentCur = nextCur;
                tr.Add(new Tracer(currentCur, movement, acc));
            }

            return tr;
        }
        public List<Tracer> SchedulingWithC_LOOK(int intialPoint)
        {
            List<Tracer> tr = new List<Tracer>();
            List<int> diff = new List<int>(); // 현재 head위치와 가장 가까운 실린더를 찾기 위해 필요한 리스트
                                              //(초기 head위치와 queue내의 실린더 간 거리)
            List<int> lst = new List<int>(); // 실린더 작업순서 정렬을 위한 임시 리스트(정렬된 리스트)
            int i = 0; // diff의 인덱스 변수
            int index = 0; // SCAN의 방향을 정하기 위해 diff 리스트 내 head위치와 가장 가까운 수의 인덱스를 저장할 변수
            int diff_min = intialPoint; // head위치와 가장 가까운 거리를 저장할 변수
            int acc = 0; // 총 이동거리를 저장할 변수
            int currentCur = intialPoint; // 현재 head위치
            int movement = 0; // 현재 head위치와 다음 head위치의 거리

            tr.Add(new Tracer(currentCur, 0, 0)); // Tracer객체 초기화
            diff.Add(diff_min); // diff리스트 초기화
            lst.Add(intialPoint); // lst리스트 초기화

            while (this.DiskQueue.Count > 0) // DiskQueue 큐에 들어간 실린더 위치를 모두 빼낼때 까지 반복
            {
                lst.Add(this.DiskQueue.Dequeue()); // DiskQueue에 무작위 수로 이루어진 큐를 빼내 lst에 추가
                diff.Add(Math.Abs(lst[i] - currentCur)); // 현재 위치와 각 실린더 위치와의 거리를 diff 리스트에 추가
                if (diff_min > diff[i]) // 가장 가까운 거리의 실린더 위치를 찾기위한 if문
                {
                    index = i;   // 가장 가까운 거리의 실린더 위치가 있는 인덱스를 index변수에 저장                
                }
                i++;
            }
            diff_min = lst[index]; // 정렬된 lst리스트에서 가장 가까운 실린더를 찾기 위해 diff_min에 lst[index]값 저장
            int tmp;
            for (i = 0; i < lst.Count - 1; i++) // lst정렬
            {
                for (int j = i + 1; j < lst.Count; j++)
                {
                    if (lst[i] > lst[j])
                    {
                        tmp = lst[i];
                        lst[i] = lst[j];
                        lst[j] = tmp;
                    }
                }
            }
            int res_index = -1, init_index = -1; // res_index -> 가장 가까운 실린더의 인덱스
                                                 // init_index -> head가 있는 실린더의 인덱스
            int fin_index = lst.Count;          // fin_index -> lst배열의 끝+1의 인덱스
            for (i = 0; i < lst.Count; i++) // 미리 저장해둔 diff_min과 initialPoint의 위치를 정렬된 lst안에서 찾기위한 반복문
            {
                if (diff_min == lst[i])
                    res_index = i;
                else if (intialPoint == lst[i])
                    init_index = i;
            }
            this.DiskQueue.Clear(); // DiskQueue 비움(초기상태에서 다시 채워넣기 위함)
            if (res_index > init_index) // Look 스케쥴링 함수와 비슷하지만 큐에 수를 채워넣는 순서가 다름
            {
                for (int j = init_index + 1; j < lst.Count; j++)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }             
                for (int k = 0; k < init_index; k++)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            else
            {
                for (int j = init_index - 1; j > -1; j--)
                {
                    this.DiskQueue.Enqueue(lst[j]);
                }
                for (int k = fin_index - 1; k > init_index; k--)
                {
                    this.DiskQueue.Enqueue(lst[k]);
                }
            }
            while (this.DiskQueue.Count > 0)
            {
                int nextCur = this.DiskQueue.Dequeue(); // 큐에 담긴 실린더 위치를 꺼내주며 이동거리를 계산한다
                if (currentCur == lst[fin_index - 1]&&nextCur==lst[0]) // 현재 위치가 요청받은 작업 실린더 중 가장 오른쪽(400에 가까운)일 경우
                {                                             // 현재 위치부터 가장 왼쪽의 실린더 작업위치로 이동한다.
                    movement = (400 - currentCur) + (nextCur);   // LOOK 했던 방향 역방향으로 되돌아 오는 것이 아니므로 
                }                                             // 가장 오른쪽 실린더 ~ 400 + 0 ~ 가장 왼쪽 실린더의 거리를 이동거리로 생각한다.
                else if (currentCur == lst[0]&&nextCur==lst[fin_index-1]) // 현재 위치가 요청받은 작업 실린더 중 가장 왼쪽(0에 가까운)일 경우
                {                                                // 현재 위치부터 가장 오른쪽의 실린더 작업위치로 이동한다.
                    movement = currentCur + (400 - nextCur);       // 가장 왼쪽 실린더 ~ 0 + 400 ~ 가장 오른쪽 실린더의 거리를 이동거리로 생각한다.
                }
                else
                {
                    movement = nextCur - currentCur;
                }
                acc = acc + Math.Abs(movement);
                currentCur = nextCur;
                tr.Add(new Tracer(currentCur, movement, acc));
            }

            return tr;
        }
    }
}
