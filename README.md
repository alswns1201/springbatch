
# thread 이해하기 
- 자바 메모리 구조 
- 메소드 영역 , 스택 영역 , 힙 영역이 존재 
- 스택 영역 :  자바 실행시 하나의 실행 스택이 생성
  - 각 스레드별로 하나의 실행 스택이 생성된다.
  - 즉. 스레드 수만큼 스택개수가 증가한다.
- 힙 영역 : 
  - 객체와 배열이 생성되는 영역 

- 생성 방법
- [1] Thread 상송 
- .start , . run  차이 ? run 은 main Thread가 직접 호출함.
- run 진행하면, main thread의 stack 공간을 차지함. 
- start 로 해줘야 개인 thread로 스택이 할당 받고 진행 됨. 

-[2] 데몬 쓰레드 
- 백그라운드에서 보조적인 작업을 수행함
- 모든 user 스레드가 종료되면 데몬 스레드는 자동으로 종료 됨 

-- 
- Runnable 사용해보기 
- Thread 상속 방법 보단 Runnable로 구현해야한다.
- 

# springbatch
Spring batch 이해하기
![image](https://github.com/user-attachments/assets/eb1b3894-975e-4159-8630-b80949cdf4cf)


Spring batch 도메인 
![sdfsdf](https://github.com/user-attachments/assets/aaa871ce-c003-4e4d-acee-791b55a0d7b6)
