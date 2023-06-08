# myshop
지금까지 학습한 내용을 정리한 백엔드 토이 프로젝트

주요 내용들은 추후 업데이트 예정


## 💻 Use Stack 
사용언어 : <img alt="Java" src ="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"/> 

프레임워크 : <img alt="Spring" src ="https://img.shields.io/badge/Spring-6DB33F.svg?&style=for-the-badge&logo=Spring&logoColor=white"/> <img alt="Spring Boot" src ="https://img.shields.io/badge/Spring Boot-6DB33F.svg?&style=for-the-badge&logo=Spring Boot&logoColor=white"/> <img alt="Spring Data Jpa" src ="https://img.shields.io/badge/Spring Data Jpa-6DB33F.svg?&style=for-the-badge&logo=Spring&logoColor=white"/>

데이터베이스 : <img alt="h2database" src ="https://img.shields.io/badge/h2database-6DB33F.svg?&style=for-the-badge&logo=&logoColor=white"/>


뷰 템플릿 : <img alt="Thymeleaf" src ="https://img.shields.io/badge/Thymeleaf-005F0F.svg?&style=for-the-badge&logo=Thymeleaf&logoColor=white"/>


IDE : <img alt="IntelliJ IDEA" src ="https://img.shields.io/badge/IntelliJ IDEA-000000.svg?&style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"/>
 
<br/>

## 📖 상세 화면

<div align="center">
  
</div>


<br/>
<br/>

> 🍽️ 해당 프로젝트는 Inflearn 의 김영한님의 강의
>- 스프링 입문 (스프링부트, 웹 MVC, DB 접근기술)
>- 스프링 핵심 원리 (기본편)
>- 모든 개발자를 위한 HTTP 웹 기본 지식
>- 스프링 MVC 1 편 (백엔드 웹 개발 핵심 기술)
>- 스프링 MVC 2 편 (백엔드 웹 개발 활용 기술)
>- 자바 ORM 표준 JPA 프로그래밍 (기본편)
>- 실전! 스프링 부트와 JPA 활용 1 편 (웹 어플리케이션 개발)<br/><br/>
>를 듣고 학습한 내용 중 개선할 부분(@Setter 제거 등)을 개선하고 학습한 내용의 기능들을 하나로 모와서 만든 웹 페이지입니다.<br/><br/>


<br/>
<br/>



## 📱 구현한 기능

- 회원가입 기능
- 중복 이름 방지 및 올바른 입력값 체크
- 회원이 아닌 사람은 상품 관리 페이지로 갈 수 없는 로그인 여부 체크 기능
- 회원목록조회
- 상품 등록 기능
- 올바른 상품명 기입을 위한 입력값 체크
- 상품 수정 기능
- 상품 주문 기능
- 주문 취소 기능
- 회원명 혹은 주문상태를 선택하여 검색조건에 따라 결과를 얻어오는 주문조회 기능


<br/>
<br/>

## 💡 특히나 인상깊었던 부분
- JPA를 활용한 DDD 설계
- JPA 를 통해 쿼리 사용을 줄이고, 변경에 자유로우며, 객체지향적인 코드를 유지할 수 있는 부분
- Setter 를 최소화하여 변경 지점을 최소환으로 관리
- 양방향 연관관계를 연관관계 메서드를 활용하여 편리하게 생성
- Entity 를 절대 반환하지말아야하고, DTO를 사용하여 반환해야함 (특히 api)
- create와 update의 validation은 많은 경우 다르므로 따로 DTO, form을 사용해서 관리해야함  

<br/>
<br/> 
