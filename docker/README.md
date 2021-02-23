## 1.docker 설치
https://www.docker.com/get-started

## 2.컨테이너 생성 및 실행
```docker
docker run <이미지이름> ls
```
- run : 컨테이너 생성 및 실행  
- 이미지이름 : 컨테이너를 생성하기 위한 이미지  
  - 이미지 : class  
  - 컨테이너 : instance  
- ls : 원래 이미지가 가지고 있는 시작 명령어를 무시하고 여기에 있는 커맨드를 실행하게 함.

## 3. 컨테이너들 나열하기
```docker
docker ps
```
- ps : process status
### 3.1. 원하는 항목만 보기
```docker
docker ps --format 'table{{.Names}}\t{{.Image}}'
```
### 3.1. 모든 컨네이터 나열
```docker
docker ps -a
```

## 4. 컨테이너의 생명주기
### 4.1. 생성(create)
```docker
docker create <이미지이름>
```
### 4.2. 시작(start)
```docker
docker start [-a] <컨테이너 아이디/이름>
```
- -a : attach의미임. 실행 output을 화면에 display
### 4.3. 실행(running)
```docker
docker run <이미지이름>
```
- 실행 = 생성 + 시작
### 4.4. 중지(stopped)
```docker
docker stop <컨테이너 아이디/이름>
```
- Gracefully하게 중지
  - 진행중이던 작업을 완료하고 컨테이너를 중지 시킨다.
### 4.5. 중지(kill)
```docker
docker kill <컨테이너 아이디/이름>
```
- Grace preiod 없이 그냥 중지 시킨다.
### 4.6. 삭제(deleted)
### 4.6.