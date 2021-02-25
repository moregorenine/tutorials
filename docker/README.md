# docker 기본
## 1.docker 설치
https://www.docker.com/get-started

## 2.컨테이너 생성 및 실행
```docker
docker run <이미지이름> <명령어>
```
- run : 컨테이너 생성 및 실행  
- 이미지이름 : 컨테이너를 생성하기 위한 이미지  
  - 이미지 : class  
  - 컨테이너 : instance  
- 명령어 : 원래 이미지가 가지고 있는 시작 명령어를 무시하고 여기에 있는 커맨드를 실행하게 함.


# 도커 클라이언트 명령어 알아보기
## 1. 컨테이너들 나열하기
```docker
docker ps
```
- ps : process status
### 1.1. 원하는 항목만 보기
```docker
docker ps --format 'table{{.Names}}\t{{.Image}}'
```
### 1.1. 모든 컨네이터 나열
```docker
docker ps -a
```

## 2. 컨테이너의 생명주기
### 2.1. 생성(create)
```docker
docker create <이미지이름>
```
### 2.2. 시작(start)
```docker
docker start [-a] <컨테이너 아이디/이름>
```
- -a : attach의미임. 실행 output을 화면에 display
### 2.3. 실행(running)
```docker
docker run <이미지이름>
```
- 실행 = 생성 + 시작
### 2.4. 중지(stopped)
```docker
docker stop <컨테이너 아이디/이름>
```
- Gracefully하게 중지
  - 진행중이던 작업을 완료하고 컨테이너를 중지 시킨다.
### 2.5. 중지(kill)
```docker
docker kill <컨테이너 아이디/이름>
```
- Grace preiod 없이 그냥 중지 시킨다.
### 2.6. 삭제(deleted)
```docker
docker rm <컨테이너 아이디/이름>
```
```docker
docker rm $(docker ps -aq) 
```
- 모든 컨테이너 삭제
```docker
docker rmi <이미지 아이디>
```
- 이미지 삭제
```docker
docker system prune
```
- 한번에 컨테이너, 이미지, 네트워크 모두 삭제
  - 도커를 쓰지 않을 때 모두 정리하고 싶을 때 사용해주면 좋음.

## 3. 실행중인 컨테이너에게 명령어를 전달
```docker
docker exec fec1bd5a9802 <명령어>
```

## 4. 레디스를 이용한 컨테이너 이해
### 4.1. redis server 작동
```docker
docker run redis
```
### 4.2. 위에서 실행중인 컨테이너에 명령어 전달
```docker
docker exec -it <컨테이너 아이디> <redis-cli>
```
- it : interactive terminal 명령어를 실행 한 후 계속 명령어를 적을 수 있다.
  - it 옵션 없을 경우 명령어 실행 후 밖으로 다시 나와버린다.

## 5. 실행 중인 컨테이너에서 터미널 유지
```docker
docker exec -it <컨테이너 아이디> <sh>
```
- sh 터미널 빠져나오기 위해서는 Ctrl + D


#  docker 이미지 생성
## 1. docker 이미지 생성 순서
### 1.1. Dockerfile 작성
- docker 이미지를 만들기 위한 설정 파일
- 컨테이너가 어떻게 행동해야 하는지에 대한 설정들을 정의해줌.
### 1.2. docker 클라이언트
- Dockerfile에 입력된 설정이 docker 클라이언트에 전달되어야 됩니다.
### 1.3. docker 서버
- docker 클라이언트에 전달된 모든 중요한 작업들을 하는 곳
### 1.4. 이미지 생성
## 2. Dockerfile 만들기
```dockerfile
# 베이스 이미지 명시
FROM baseImage
#<이미지 이름>:<태그>
#ex) ubuntu:14.04
#태그 없을 경우 최신버젼

# 추가적으로 필요 파일 다운로드
RUN command
#docker 이미지가 생성되기 전에 수행할 쉘 명령어

# 컨테이너 시작시 실행 될 명령어
CMD ["executable"]
#해당명령어는 Dockerfile내 1회만 쓸 수 있음
```
```dockerfile
FROM alpine
#RUN command
CMD ["echo", "hello"]
```
## 3. Dockerfile로 docker 이미지 만들기
### 3.1. flow
- Dockerfile -> docker client -> docker server -> docker image
### 3.2. build
```docker
docker build ./
or
docker build .
```
- build 명령어는 해당 디렉토리 내에서 Dockerfile을 찾아 docker client에게 전달시켜준다.
## 4. 내가 만든 이미지 기억하기 쉬운 이름 주기
```docker
docker build -t <my docker ID>/<저장소/프로젝트명>:<version> ./
ex)
docker build -t moregorenine/alpine-hello:latest ./
```
# docker를 이용한 간단한 node.js 어플 만들기
## 1. Node.js 앱 만들기
- [2.make-node.js-image](2.make-node.js-image)
```docker
docker build -t moregorenine/nodejs-express:latest ./
```
## 2. port mapping
```docker
docker run -p <외부 네트워크 port>:<docker 컨테이너의 port> <image 이름>
ex)
docker run -p 8090:8080 moregorenine/nodejs-express
```
- 외부 네트워크의 port와 docker 컨테이너의 port를 mapping 해준다.
## 3. 어플리케이션 소스 변경으로 다시 빌드하는 것에 대한 문제점
```docker
docker run -d -p 8090:8080 moregorenine/nodejs-express
```
- -d : DETACH 실행 후 바로 빠져 나온다.
## 4. Docker Volume
### 4.1. COPY는 로컬의 데이타를 docker 컨테이너로 복사
### 4.2. volume은 docker 컨테이너가 로컬의 데이타를 참조
### 4.3. example
```docker
docker run -d -p 8090:8080 -v /usr/src/app/node_modules -v %cd%:/usr/src/app moregorenine/nodejs-express
```
- -v /usr/src/app/node_modules : 호스트 디렉토리에 node_modules이 없기에 컨테이너에게 맵핑하지 말라고 하는 것
- -v %cd%:/usr/src/app : cd 경로에 있는 디렉토리 혹은 파일을 /usr/src/app 경로에서 참조
- 맥 : -v $(pwd):/usr/src/app
- 윈도우 -v %cd%:/usr/src/app
# Docker Compose
## 1. 어플리케이션 소스 작성하기
- [3.docker-compose-app](3.docker-compose-app)
## 2. redis server 실행하기
### 2.1. server.js의 redis client가 통신하기 위한 redis server가 우선 실행되어야 한다.
```docker
docker run redis
```
## 3. Docker Compose 파일 작성하기
### 3.1. Docker Compose 실행
```docker
docker-compose up [-d] [--build]
```
- --build : image 있던 없던 build하고 컨테이너 시작
  - 이 옵션이 없을 경우 image 존재하면 build 없이 컨테이너 시작
## 4. Docker Compose로 컨테이너를 멈추기
```docker
docker-compose down
```