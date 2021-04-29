## 과제를 수행하며 작성한 스프링 프레임워크 웹 프로젝트입니다.

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
3. jsp 파일에서 result URL 요청시 폼내의 입력된 이름, 직업을 콘솔에 출력 (변수 두개 이상)
> 모델로 관리했습니다. 모델의 변수명과 form 내의 input 태그의 name 속성이 모두 맞다면 따로 맵핑하는 함수가 없어도 컨트롤러 함수에 자동으로 받아옵니다. <br> 
* <b>applicationContext.xml :</b> Application에서 사용할 Spring 자원들을 설정하는 파일입니다.


기존 01 프로젝트의 xml 파일을 활용한 의존성 주입을 annotation을 
