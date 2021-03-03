# [기초편] 기초 다지기
## 1. Why Kubernetes?
- Auto Scaling
  - 트랙픽 양에 따라 서비스의 자원양을 변경
- Auto Healing
  - 장애 서버 자동 대체
- Deployment
  - Rolling Update
  - ReCreate
## 2. Getting started - Kubernetes - 실습
- [1.getting-started](1.getting-started)
### 2.1. Docker Image 생성
```docker
docker build -t moregorenine/hello.js ./
```
### 2.2. Docker Image 실행
```docker
docker run -d -p 8080:8000 moregorenine/hello.js
```
### 2.3. Docker 컨테이너 접속
```docker
docker exec -it [CONTAINER ID] bin/bash
```
### 2.4. Docker Image push
```docker
docker login
docker push moregorenine/hello.js
```
### 2.5. kubernetes dashboard 설치
https://collabnix.com/kubernetes-dashboard-on-docker-desktop-for-windows-2-0-0-3-in-2-minutes/
```bash
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml
```
```bash
kubectl proxy
```
```bash
http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/
```
```bash
$TOKEN=((kubectl -n kube-system describe secret default | Select-String "token:") -split " +")[1]
```
### 2.6. pod 등록
```yml
apiVersion: v1
kind: Pod
metadata:
  name: hello-pod
  labels:
    app: hello
spec:
  containers:
  - name: hello-container
    image: kubetm/hello
    ports:
    - containerPort: 8000
```
### 2.7. service 등록
```yml
apiVersion: v1
kind: Service
metadata:
  name: hello-svc
spec:
  selector:
    app: hello
  ports:
    - port: 8200
      targetPort: 8000
  externalIPs:
  - 127.0.0.1
```
## 3. Kubernetes Overview