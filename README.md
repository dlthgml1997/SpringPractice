<b>과제를 수행하며 작성한 스프링 프레임워크 웹 프로젝트입니다.</b>

### 01. HW_SF_01_DI
xml 파일을 활용한 의존성 주입(Dependency Injection) 연습 <br>
* <b>applicationContext.xml :</b> Application에서 사용할 Spring 자원들을 설정하는 파일입니다.
> Spring Container는 ProductRepoImpl.java 파일에서 setDataSource를 통해 Spring 자원을 자동으로 얻어옵니다.
> DB와의 연결을 맺고 끊는 단계를 줄여줍니다. <br>
<br>

### 02. HW_SF_02_MVC
스프링 MVC 프로젝트 연습 <br>
> 프로젝트 생성 방법:  Spring Legacy Project -> Spring MVC Project <br>
1. `@Controller` 어노테이션으로 controller 클래스를 작성하고, jsp 파일을 호출하는 기능
2. jsp 파일에서 result URL 요청시 폼내의 입력된 이름을 콘솔에 출력 (변수 하나)
3. jsp 파일에서 result URL 요청시 폼내의 입력된 이름, 직업을 콘솔에 출력 (변수 두개 이상)<br>
* 이때, 이름, 직업을 userDto로 관리했습니다. 모델의 변수명과 form 내의 input 태그의 name 속성이 모두 맞다면 따로 맵핑하는 함수가 없어도 컨트롤러 함수에 자동으로 받아옵니다. <br>
4. 계산기 기능을 구현했습니다. 
<br>

### 03. HW_SF_03_DI_MVC_DB
스프링 MVC + DI + DB 연습 <br>
기존 xml 방식 DI 에서 annotation(`@`)과 java config file을 이용한 DI 방식으로 변경했습니다.<br>
상품 등록 및 상품 목록 기능을 구현했습니다.<br>
<br>

### 04. HW_SF_04_MyBatis
Spring & MyBatis <br>
ORM(Object Relational Mapping) Framework 인 MyBatis를 적용해 product CRUD 기능을 구현했습니다. <br>
* 수동적인 parameter 설정과 Query 결과에 대한 mapping 구문을 제거했습니다.
* root-context.xml 파일에 sql mapper 파일의 위치를 지정합니다.
* sql mapper file(product.xml) 에는 CRUD에 대한 SQL문이 작성되어 있습니다. 이 파일에서 Dao와의 mapping이 일어납니다.
   * 기존 ProductDaoImpl.class 기능을 product.xml에서 하기 때문에 삭제됐습니다.  
* 서비스 클래스에서는 `@Autowired` 어노테이션으로 SqlSession을 통해 Dao 인터페이스의 기능을 사용합니다.
* mybatis-config.xml 파일에는 Product Dto를 간결하게 작성하기 위한 alias가 작성되어 있습니다.
