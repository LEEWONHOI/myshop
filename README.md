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
>(본 깃허브는 8월까지 public 상태 유지 후 private 상태로 전환됩니다.) 


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

## 📋 추후 기능 구현 시 참고할 자료

- 웹 애플리케이션 서버의 요청 응답 구조

![image](https://user-images.githubusercontent.com/78194843/164617973-b13e9e8a-52e8-4db3-8167-7737301858bb.png)


<br/>
<br/>

### HTTP Request 요청 데이터의 3가지 방법
주로 다음 3가지 방법을 사용한다.
- GET - 쿼리 파라미터
  - /url?username=hello&age=20
  - 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
  - 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
  > GET URL 쿼리 파라미터 형식으로 클라이언트에서 서버로 데이터를 전달할 때는 HTTP 메시지 바디를
사용하지 않기 때문에 content-type이 없다

- POST - HTML Form
  - content-type: application/x-www-form-urlencoded
  - 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20
  - 예) 회원 가입, 상품 주문, HTML Form 사용
  - 요청 파라미터와 다르게, HTTP 메시지 바디를 통해 데이터가 직접 데이터가 넘어오는 경우는 **@RequestParam , @ModelAttribute**를 사용할 수 없다
  > POST HTML Form 형식으로 데이터를 전달하면 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기
때문에 바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야 한다. 이렇게 폼으로 데이터를
전송하는 형식을 application/x-www-form-urlencoded 라 한다.
  
- HTTP message body에 데이터를 직접 담아서 요청
  - HTTP API에서 주로 사용, JSON, XML, TEXT
  - 데이터 형식은 주로 JSON 사용
  - POST, PUT, PATCH

  > content-type: application/json

POST- HTML Form 예시

![image](https://user-images.githubusercontent.com/78194843/164618224-831edb74-b7f8-421a-b4e8-10ccfcbd9b6a.png)

<br/>
<br/>

### @RequestBody
- @RequestBody 를 사용하면 HTTP 메시지 바디 정보를 편리하게 조회할 수 있다. 참고로 헤더 정보가
필요하다면 HttpEntity 를 사용하거나 @RequestHeader 를 사용하면 된다.
이렇게 메시지 바디를 직접 조회하는 기능은 요청 파라미터를 조회하는 @RequestParam ,
@ModelAttribute 와는 전혀 관계가 없다.
### 요청 파라미터 vs HTTP 메시지 바디
- 요청 파라미터를 조회하는 기능: @RequestParam , @ModelAttribute
HTTP 메시지 바디를 직접 조회하는 기능: @RequestBody
### @ResponseBody
- @ResponseBody 를 사용하면 응답 결과를 HTTP 메시지 바디에 직접 담아서 전달할 수 있다.
물론 이 경우에도 view를 사용하지 않는다.


### @ResponseBody 사용 원리

![image](https://user-images.githubusercontent.com/78194843/164625249-4bf1f6b1-9ddf-4f06-9837-01b4371f7b55.png)
- @ResponseBody 를 사용
  - HTTP의 BODY에 문자 내용을 직접 반환
  - viewResolver 대신에 HttpMessageConverter 가 동작
  - 기본 문자처리: StringHttpMessageConverter
  - 기본 객체처리: MappingJackson2HttpMessageConverter
  - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음


스프링 MVC는 다음 파라미터를 지원한다.
- HttpEntity: HTTP header, body 정보를 편리하게 조회
  - 메시지 바디 정보를 직접 조회
  - 요청 파라미터를 조회하는 기능과 관계 없음 @RequestParam X, @ModelAttribute X
- HttpEntity는 응답에도 사용 가능
  - 메시지 바디 정보 직접 반환
  - 헤더 정보 포함 가능
  - view 조회X
  
HttpEntity 를 상속받은 다음 객체들도 같은 기능을 제공한다.
- RequestEntity
  - HttpMethod, url 정보가 추가, 요청에서 사용
- ResponseEntity
  - HTTP 상태 코드 설정 가능, 응답에서 사용
  - return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED)


<br/>
<br/>

### HttpServletResponse - 기본 사용법

- 단순 텍스트 응답
  - ( writer.println("ok"); )
- HTML 응답
- HTTP API - MessageBody JSON 응답


<br/>
<br/>

MVC 패턴 <br/>
![image](https://user-images.githubusercontent.com/78194843/164619732-16f7575e-423b-4b94-9ac1-a36d02430baf.png)



<br/>
<br/>

### SpringMVC 구조 <br/>
![image](https://user-images.githubusercontent.com/78194843/164620093-b3992fa9-8531-43df-bd51-883b38d273ce.png)

동작 순서
1. 핸들러 조회: 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
2. 핸들러 어댑터 조회: 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
3. 핸들러 어댑터 실행: 핸들러 어댑터를 실행한다.
4. 핸들러 실행: 핸들러 어댑터가 실제 핸들러를 실행한다.
5. ModelAndView 반환: 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서 반환한다.
6. viewResolver 호출: 뷰 리졸버를 찾고 실행한다. (JSP의 경우: InternalResourceViewResolver 가 자동 등록되고, 사용된다.)
7. View 반환: 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환한다.
JSP의 경우 InternalResourceView(JstlView) 를 반환하는데, 내부에 forward() 로직이 있다.
8. 뷰 렌더링: 뷰를 통해서 뷰를 렌더링 한다

+ 추가 
### RequestMappingHandlerAdapter 동작 방식 <br/>
  ![image](https://user-images.githubusercontent.com/78194843/164626186-f5c8df0e-daf9-4d15-8427-24e56f0aa4c4.png)

### ArgumentResolver
생각해보면, 애노테이션 기반의 컨트롤러는 매우 다양한 파라미터를 사용할 수 있었다.<br/>
HttpServletRequest , Model 은 물론이고, @RequestParam , @ModelAttribute 같은 애노테이션 그리고 @RequestBody , HttpEntity 같은 HTTP 메시지를 처리하는 부분까지 매우 큰 유연함을 보여주었다.<br/>
이렇게 파라미터를 유연하게 처리할 수 있는 이유가 바로 ArgumentResolver 덕분이다.<br/>
애노테이션 기반 컨트롤러를 처리하는 RequestMappingHandlerAdaptor 는 바로 이 ArgumentResolver 를 호출해서 컨트롤러(핸들러)가 필요로 하는 다양한 파라미터의 값(객체)을 생성한다.<br/>
그리고 이렇게 파리미터의 값이 모두 준비되면 컨트롤러를 호출하면서 값을 넘겨준다.<br/>
스프링은 30개가 넘는 ArgumentResolver 를 기본으로 제공한다.<br/>

  
  
<br/>
<br/>

### PRG Post/Redirect/Get <br/>
  ![image](https://user-images.githubusercontent.com/78194843/164626420-117adf23-dac8-4afb-acfb-b4a14ae27e2f.png)

  
웹 브라우저의 새로 고침은 마지막에 서버에 전송한 데이터를 다시 전송한다.<br/>
새로 고침 문제를 해결하려면 상품 저장 후에 뷰 템플릿으로 이동하는 것이 아니라, 상품 상세 화면으로 리다이렉트를 호출해주면 된다.<br/>
웹 브라우저는 리다이렉트의 영향으로 상품 저장 후에 실제 상품 상세 화면으로 다시 이동한다. 따라서 마지막에 호출한 내용이 상품 상세 화면인 GET /items/{id} 가 되는 것이다.<br/>
이후 새로고침을 해도 상품 상세 화면으로 이동하게 되므로 새로 고침 문제를 해결할 수 있다<br/>

<br/>
<br/>

```java
  @ModelAttribute("regions")
public Map<String, String> regions() {
 Map<String, String> regions = new LinkedHashMap<>();
 regions.put("SEOUL", "서울");
 regions.put("BUSAN", "부산");
 regions.put("JEJU", "제주");
 return regions;
}
  

  @ModelAttribute("itemTypes")
public ItemType[] itemTypes() {
 return ItemType.values();
}
```
  
 ### @ModelAttribute의 특별한 사용법
등록 폼, 상세화면, 수정 폼에서 모두 서울, 부산, 제주라는 체크 박스를 반복해서 보여주어야 한다. <br/> 
  이렇게 하려면 각각의 컨트롤러에서 model.addAttribute(...) 을 사용해서 체크 박스를 구성하는 데이터를반복해서 넣어주어야 한다.<br/>
  <br/>
@ModelAttribute 는 이렇게 컨트롤러에 있는 별도의 메서드에 적용할 수 있다.<br/>
이렇게하면 해당 컨트롤러를 요청할 때 regions 에서 반환한 값이 자동으로 모델( model )에 담기게 된다.<br/>
물론 이렇게 사용하지 않고, 각각의 컨트롤러 메서드에서 모델에 직접 데이터를 담아서 처리해도 된다.<br/>
  
<br/>
<br/>
  
## 타임리프 기능들

- th:object : 커맨드 객체를 지정한다.
- *{...} : 선택 변수 식이라고 한다. th:object 에서 선택한 객체에 접근한다.
- th:field
  - HTML 태그의 id , name , value 속성을 자동으로 처리해준다.
  - 렌더링 전 <input type="text" th:field="*{itemName}" />
  - 렌더링 후 <input type="text" id="itemName" name="itemName" th:value="*{itemName}" />
  - 사실 이것의 진짜 위력은 검증(Validation)에서 나타난다. 
  - 체크박스의 값이 true 인 경우 checked 속성을 자동으로 처리해준다.
- 체크박스 사용 시 히든필드도 자동으로 생성해줘서 체크 박스를 선택하지 않은 경우 null 이 아닌 false 를 반환시킨다.
- th:each 안에서 th:for="${#ids.prev('regions')}" 를 사용 시 임의로 아이디 + 숫자 값을 붙여준다.
  

<br/>
<br/>

  
