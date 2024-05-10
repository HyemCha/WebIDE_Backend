# WebIDE_Backend

# WEB IDE 프로젝트 🖥️

배포 URL : https://woowabirdieside.com (비용문제로 인해 사이트는 내린 상태입니다.)
<br>
백엔드 Repository : https://github.com/Woowa-Birdies/WebIDE_Backend
<br>
프론트엔드 Repository : https://github.com/Woowa-Birdies/WebIDE_Frontend
<br>
팀 노션 페이지 : https://www.notion.so/Web-IDE-Project-2ebdc7d72b3e4ee9956cce17e6cb856a
<br>

---

<br>

### 순간이동 🛸

[개발 기간](#개발-기간-🗓️) | [팀원](#팀원-⚡️) | [컨셉](#컨셉-💫) | [인프라 설계도](#인프라-설계도-📜) | [사용 기술 및 라이브러리](#사용-기술-및-라이브러리-🗂️) | [역할 분담](#역할-분담-🔗) | [프로젝트 관리](#프로젝트-관리-🗃️) | [시연 및 기능 설명](#시연-및-기능-설명-💻) | [시퀀스 다이어그램](#시퀀스-다이어그램-🗒️) | [회고](#회고-💭)

<br>

## 개발 기간 🗓️
>2024/01/29 ~ 2024/02/26

<br>

## 팀원 ⚡️

|윤지윤|양지원|조현성|차혜민|한세웅|
|:---:|:---:|:---:|:---:|:---:|
|[<img src="https://avatars.githubusercontent.com/jeeyn" height=150 width=150 style="border-radius:50%;">](https://github.com/jeeyn)|[<img src="https://avatars.githubusercontent.com/ambosing" height=150 width=150 style="border-radius:50%;">](https://github.com/ambosing)|[<img src="https://avatars.githubusercontent.com/Jhsysng" height=150 width=150 style="border-radius:50%;">](https://github.com/Jhsysng)|[<img src="https://avatars.githubusercontent.com/HyemCha" height=150 width=150 style="border-radius:50%;">](https://github.com/HyemCha)|[<img src="https://avatars.githubusercontent.com/SeWoong-Han" height=150 width=150 style="border-radius:50%;">](https://github.com/SeWoong-Han)|
|팀장⭐️ <br>코드 편집기 <br/>FE&BE|코드 편집기 <br/>FE&BE|채팅 <br/>FE&BE|로그인/회원가입 <br/>FE&BE|채팅 <br/>FE&BE|

<br>

## 컨셉 💫
    - 코딩테스트를 필요로 하는 기업에 제공하는 서비스
    - 이용자 : 관리자(기업의 코딩테스트 관리자), 응시자
    - 관리자가 코딩테스트 프로젝트를 만들고 지원자에게 프로젝트 링크를 전달하면 지원자는 해당 링크로 들어가 언어를 선택하고 코딩테스트를 진행한다.

<br>

## 인프라 설계도 📜

![인프라 설계도](<img width="782" alt="image" src="https://github.com/HyemCha/WebIDE_Backend/assets/89293165/570c475c-655a-42f6-95b7-7beb2239987b">)

- Github Actions를 이용해 CI/CD 구축
- FE : S3 버킷에 빌드된 파일을 업로드하여 배포
    - Cloud Front를 통해서 S3 버킷의 자원에 접근
    - Route53으로 Cloud Front에서 배포한 URL을 구매한 도메인과 연동
    - AWS Certificate Manager 에서 발급받은 SSL 인증서 적용
- BE : 
    - 로드밸런서를 이용해 HTTP로 HTTPS 리다이렉트 및 리버스 프록시 설정
    - CodeDeploy를 활용한 자동 배포화 설정
    - Git Submodule를 이용한 Private한 파일들을 따로 분리하여 보안 설정
    - EC2, RDS 프로비저닝
- 로드밸런서를 이용해 프론트엔드와 백엔드 연결

<br>

## 사용 기술 및 라이브러리 🗂️

**UI**
: AntDesign, Monaco Editor, Styled-Components,

**프론트엔드**
: React, Redux, Axios, Stomp

**백엔드**
: SpringBoot, JPA, SpringSecurity, WebSocket, 

**DB**
: MySQL, MongoDB

<br>

## 역할 분담 🔗
도메인별로 파트를 나누어 풀스택 개발을 하였음
```
├── 유저 - 차혜민
├── 코드 편집기 - 윤지윤, 양지원
└── 채팅 - 조현성, 한세웅
```

### 윤지윤
- **UI** :
    - 페이지 : IDE[관리자/응시자] | 프로젝트 페이지
- **프론트엔드** :
    - Monaco Editor를 사용한 IDE 환경 구성
- **백엔드** :
    - IDE 파트 api 개발 
    
### 양지원
- **UI** :
    - 페이지 : IDE[관리자/응시자] | 프로젝트 페이지
- **백엔드** :
    - IDE 파트 api 개발 : 
        - 면접 IDE, 응시자, 문제 CRUD 구현
        - 해시 값 검증 기능 구현
        - 코드 실행 기능 구현
        - 테스트 코드 구현

### 조현성
- **UI** :
    - 페이지 : 채팅 페이지
- **프론트엔드** :
    - 메세지 컴포넌트 구현
- **백엔드** :
    - 채팅 파트 api 개발 : 
        - mongodb 구축
        - spring boot service 작성
        - stomp 설정

### 차혜민
- **UI** :
    - 페이지 : 로그인/회원가입 페이지 | 로딩 페이지
- **프론트엔드** :
    - kakao/google 소셜 로그인 구현
- **백엔드** :
    - SpringScurity와 JWT를 적용, 소셜 로그인 구현
    - 유저 파트 api 개발 : 로그인/회원가입, 유저 정보 수정/삭제

### 한세웅
- **UI** :
    - 페이지 : 채팅 페이지
- **프론트엔드** :
    - 채팅방 컴포넌트 구현
- **백엔드** :
    - 채팅 파트 api 개발 : 
        - 채팅 컨트롤러, 핸들러 작성

<br>

## 프로젝트 관리 🗃️
- 정기 회의(월/수/금 오전 10:30)
    - 모든 회의는 회의록을 꼼꼼히 작성하여 프로젝트 기간 내 지속적인 참고
- Notion을 통한 문서화
    - 요구사항 정의서, API 정의서, 시퀀스 다이어그램 등 모든 개발 문서 체계화
- GitHub Organization 생성을 통한 프로젝트 관리
    - 모든 코드 병합은 Pull-Request-Review 및 Review 과정을 거침
    - GitHub Actions를 통한 CI/CD 구축

<br>

## 시연 및 기능 설명 💻

**[로그인/회원가입]** - 로그아웃 시 초기화면

- 카카오/구글 소셜 로그인 및 회원가입이 가능합니다.
- 로그인에 성공하면 서버에서 유저 정보와 accessToken, refreshToken을 프론트엔드로 넘겨주고 브라우저의 로컬 스토리지에 해당 정보들을 저장합니다.
- 로그인에 성공하면 프로젝트 페이지로 넘어갑니다.

|로그인/회원가입|코드|
|---|---|
|![로그인/회원가입](로그인_회원가입.gif)|코드|

<br>

**[회원 관리]**

- 유저는 마이페이지에서 본인의 닉네임을 변경할 수 있습니다.
- 탈퇴 버튼을 누르면 DB에서 회원의 정보 및 회원이 생성한 프로젝트들이 삭제됩니다.

|회원 관리|탈퇴|
|---|---|
|![회원 관리](시연.gif)|탈퇴gif|

<br>

**[로그아웃]**

- 로그아웃을 하면 브라우저의 로컬 스토리지에 저장되었던 사용자 정보가 삭제되고 로그인/회원가입 페이지로 이동합니다.

|로그아웃|코드|
|---|---|
|![로그아웃](로그인_회원가입.gif)|코드|

<br>

**[프로젝트 페이지]**

- 유저(관리자)가 생성한 프로젝트(코딩테스트 환경) 리스트가 뜹니다.

|프로젝트 페이지|코드|
|---|---|
|![프로젝트 페이지](시연.gif)|코드|

<br>

**[IDE 생성 / 삭제]**

- 유저(관리자)는 프로젝트를 생성 및 삭제를 할 수 있습니다.
- 유저는 프로젝트 생성 시 문제를 정할 수 있습니다.

|IDE 생성|IDE 삭제|
|---|---|
|![IDE 생성](시연.gif)|![IDE 삭제](시연.gif)|

<br>

**[응시자 초대 - 관리자]**

- 공유 버튼을 누르면 hash 코드가 포함된 프로젝트(코딩테스트 환경) 링크가 뜨고, 해당 링크를 응시자에게 전달할 수 있습니다.
- 응시자는 hash 코드가 일치하지 않으면 입장이 불가능합니다.

|응시자 초대|
|---|
|![응시자 초대](시연.gif)|

<br>

**[환경 설정 / 코드 실행 - 응시자]**

- 응시자는 코딩테스트 환경 입장 시 언어, 생년월일, 응시자명을 필수로 입력해야합니다.
- 코드를 실행하면 자동 저장됩니다.
- 코드는 실행하지 않고 저장가능합니다.

|언어 설정|코드 실행|
|---|---|
|![언어 설정](시연.gif)|![코드 실행](시연.gif)|


<br>

**[관리자 감독]**

- 관리자는 생성한 코딩테스트 환경에 접속해 응시자의 코딩테스트 현황을 1초마다 확인 가능합니다.

|관리자 감독|
|---|
|![관리자 감독](시연.gif)|

<br>

**[채팅]**

- 응시자는 해당 코딩테스트의 관리자와 1:1 채팅이 가능합니다.

|채팅|
|---|
|![채팅](시연.gif)|

<br>

## 시퀀스 다이어그램 🗒️

### 유저
(로그인 회원가입 png)

### IDE CRUD
(ide png)

### 채팅
(coxld png)

<br>

## 회고 💭
**좋았던 점 👍**
- 팀원 모두의 Full-Stack 개발
    - 도메인 주도 설계와 기능 위주로 세분화 한 작은 스프린트 단위의 개발 프로젝트를 경험해 볼 수 있어 좋았습니다.
- 클라우드 인프라 서비스 및 CI / CD 적용
    - EC2, S3를 비롯하여 Cloud Front, EFS, ECS 등 다양한 클라우드 서비스를 활용하여 CI/CD 까지 적용해 볼 수 있었던 좋은 경험이었습니다.

**아쉬웠던 점 🤔**
- Front-end 개발 경험 부족 
    - 팀원 모두 프론트엔드 개발과 관련한 경험이 부족하고, 개발기능에 비해 팀원 수가 적어 시행착오가 많았습니다.
- 일정 지연과 돌발 이슈로 인한 설계 변경
    - 위의 상황과 따라 당초 계획했던 것보다 일정이 일부 지연되어 후순위 요구사항까지는 개발하지 못해 아쉽습니다.
    - AWS Access Key 유출로 인해 계정이 중지되면서 계획했던 대로 배포까지 마무리하지 못한 점도 아쉽습니다.

<br>

## 백엔드 디렉토리 구조
```
├── InitDummyData.java
├── WebideApplication.java
├── candidate
│   ├── controller
│   ├── domain
│   ├── repository
│   └── service
├── chat
│   ├── ChatController.java
│   ├── domain
│   └── repository
├── common
│   ├── domain
│   └── handler
├── config
│   ├── AwsConfig.java
│   ├── MongoConfig.java
│   ├── SecurityConfig.java
│   └── WebSocketConfig.java
├── efs
│   └── service
├── member
│   ├── MemberRepository.java
│   ├── MemberService.java
│   ├── controller
│   ├── data
│   ├── security
│   └── util
├── problem
│   ├── controller
│   ├── domain
│   ├── repository
│   └── service
└── project
    ├── controller
    ├── domain
    ├── repository
    ├── service
    └── util
```
