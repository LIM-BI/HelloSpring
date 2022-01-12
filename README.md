
// 2022-01-12
- 
- 설정 정보 사용
- @Bean(initMethod = "지정할 메서드" , destroyMethod = "지정할 메서드")
- 장점
- 메서드 이름을 자유롭게 줄 수 있다.
- 스프링 빈이 스프링 코드에 의존하지 않는다.
- 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드 적용 가능
-
- 애노테이션 @PostConstruct, @PreDestroy
- 최신 스프링에서 가장 권장하는 방법.
- 애노테이션 하나만 붙이면 되므로 매우 편리하다.
- 스프링에 종속적인 기술이 아니라 JSR-250라는 자바 표준이여서 다른 컨테이너에서도 잘 작동한다.
- 컴포넌트 스캔과 잘 어울린다.
- 단점은 외부 라이브러리에는 적용하지 못한다. 외부 라이브러리에는 설정 정보 사용.


// 2022-01-11
- 
- 빈 생명주기 콜백 시작
- 데이터베이스 커넥션 풀이나, 네트워크 소켓처럼 애플리케이션 시작 시점에 필요한 연결을 미리 해두고,
- * 데이터베이스 커넥션 풀이란? 웹서버랑 데이터베이스랑 연결을 미리 맺어놓는다.
- 애플리케이션 종료 시점에 연결을 모두 종료하는 작업을 진행하려면, 객체의 초기화와 종료 작업이 필요하다.
- 
- 스프링 빈의 이벤트 라이프 사이클
- 스프링 컨테이너 생성 → 스프링 빈 생성 → 의존관계 주입 → 초기화 콜백 → 사용 → 소멸전 콜백 → 스프링 종료
-
- 스프링은 크게 3가지 방법으로 빈 생명주기 콜백을 지원한다.
- * 인터페이스(InitializingBean, DisposableBean)
- * 설정 정보에 초기화 메서드, 종료 메서드 지정
- * @PostConstruct, @PreDestory 애노테이션 지원
-
- 인터페이스(InitializingBean, DisposableBean)
- 단점)
- 스프링 전용 인터페이스, 해당 코드가 스프링 전용 인터페이스에 의존.
- 초기화, 소멸 메서드의 이름을 변경할 수 없다.
- 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.   

// 2022-01-10
- 
- 여러개의 빈을 Map과 List 형태로 받기 (AllBeanTest.class) 
- 의존관계 자동 주입 정리!~!!
- 편리한 자동 기능을 기본으로 사용하자
- 광범위하게 영향을 미치는 기술 지원 객체는 수동 빈으로 등록해서 설정 정보에 바로 나타나게 하는 것이 유지보수 하기 좋다.
- 혹은 자동으로 등록하고 싶으면 최소한 같은 패키지에 묶어두자!
- 다형성을 적극 활용하는 비즈니스 로직은 수동 등록을 고민해보자!

// 2022-01-04
-
- 롬복 라이브러리 추가
- 롬복 설치
- HelloLombok 클래스 추가
- @RequiredArgsConstructor → final 붙은 클래스의 생성자를 자동으로 만들어준다.
-
- 조회 빈이 2개 이상인 경우 해결방법
- 1. @Autowired (첫번째로 타입 매칭을 하고 만약 빈이 2개 이상일 경우, 파라미터 이름으로 빈 이름을 추가 매칭한다. 필드 혹은 생성자)
-   → @Autowired private DiscountPolicy rateDiscountPolicy
-   → @Autowired 생성장
- 2. @Qualifier("이름") (구분자로써 필드나 생성자 파라미터에 @Qualifier("이름") 작성해주면 해당이름의 빈으로 찾아와서 주입해준다.)
-   → Qualifier끼리 매칭, 빈이름 매칭, 그래도 없으면 NoSuchBeanDefinitionException 예외 발생
- 3. @Primary (우선 순위를 지정)
-   → 해당 어노테이션이 붙은 빈이 우선 선택된다.
-
- * @Qualifier와 @Primary 중 @Qualifier가 우선권을 가진다.
-
- 어노테이션 직접 만들기


// 2022-01-03
-
- 옵션처리 
- required = false → 호출 자체가 안된다.
- @Nullable → 스캔은 되는데 null.
- Optional<> → 스프링 빈이 없으면 Optional.empty로 확인
- 
- 최근에는 생성자 주입을 선택하는 이유
- * 불변 → 대부분의 의존관계 주입은 한번 일어나면 애플리케이션 종료시점까지 의존관계를 변경할 일이 없다.
- * 누락 → 프레임워크 없이 순수한 자바 코드를 단위 테스트 하는 경우에 
- * final 키워드 → 생성자에서 혹시라도 값이 설정되지 않는 오류를 컴파일 시점에 막아준다.
-




// 2021-12-30
-
- 의존관계 주입 방법
- * 생성자 주입 (불변, 필수 의존관계에 사용)
- * 수정자 주입(setter, 선택/변경 가능성이 있는 의존관계에 사용, 주입할 대상이 없어도 동작하게 하려면 @Autowired(required = false)로 정의)
- * 필드 주입
- * 일반 메서드 주입


// 2021-12-29
-
- 지금까지 스프링 빈을 등록할때는 자바 코드에 @Bean이나 XML 등을 통해서 설정 정보에 직접 등록할 스프링 빈을 나열했는데,
- 이렇게 등록할 빈이 수십, 수백개가 되면 일일이 등록하기도 번거롭고, 설정 정보도 커지고 누락하는 문제가 발생한다.
- 그래서 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.
- 또 의존관계도 자동으로 주입하는 @Autowired 기능도 제공한다.
-
- AutoAppConfig.java 클래스 생성 
- @ComponentScan (excludeFilters는 제외할 클래스 정의, includeFilters는 추가할 클래스를 정의)
- 스프링 빈으로 자동 등록할 클래스에 @Component 추가
- 의존성 주입할 생성자 코드에 @Autowired 추가 
- @ComponentScan은 basePackages = "추가할 패키지명"을 써주면 스캔할 패키지를 지정해줄수 있다.(기본은 자신이 속해있는 패키지) 
- 여러개 정의할때는 {"패키지명","패키지명"}  
- @Component 스프링 빈의 기본 이름은 클래스명에서 맨 앞글자만 소문자로 바꿔서 사용 (MemberServiceImpl -> memberServiceImpl)
- @Component("memberService2") 이런식으로 이름을 정의해줄수있다.
-
- @Controller, @Repository, @Configuration, @Service 도 컴포넌트 스캔의 대상이다. 
- @Repository - 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
- @Service 사실 해당 어노테이션은 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는데 도움.
-
- 수동 빈과 자동 빈 등록 이름이 같을때, 수동빈이 먼저 우선권을 가지고 수동 빈이 자동 빈을 오버라이딩 해버린다.
- 오버라이딩의 경우 애매한 오류로 꼬일수가 있어서 스프링 부트에서는 오버라이딩을 기본으로 지원하지 않는다.(스프링 자체에서는 오버라이딩이 기본)


// 2021-12-28
-
- 싱글톤 컨테이너
- 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤으로 관리한다.
- 지저분한 코드를 작성하지 않아도 된다. DIP, OCP, 테스트, private 단점을 커버
- 우리가 스프링 컨테이너에 스프링 빈으로 등록했던 객체들이 모두 싱글톤 객체이다.
-
- 싱글톤 방식의 주의점
- 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에
- 싱글톤 객체는 상태를 유지하게 설계하면 안된다.
- 무상태로 설계해야 한다.
- * 특정 클라이언트에 의존적인 필드가 있으면 안된다.
- * 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
- * 가급적 읽기만 가능해야 한다.
- * 필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
-
- @Configuration을 안붙이면 스프링 빈으로 등록은 되지만, 싱글톤은 보장하지 않는다.
- ** config.java 클래스를 호출하면 (@Configuration 어노테이션이 붙은) 클래스명 뒤에 이상한 문자가 포함되어 있다.
-    이는 내가 만든 클래스가 아니라 스프링이 CGLIB이라는 바이트코드 조작 라이브러리를 사용해서 config 클래스를
-    상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한것이다.
-    이와 같은 방법으로 싱글톤이 보장되는것이다.


// 2021-12-26
-
- xml로 빈 설정
- Definition Test


// 2021-12-25
-
- 등록된 모든 빈 출력 테스트
- // ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
- // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈 
- 스프링 빈 조회 getBean(이름, 타입)
- 실패 테스트까지 완료
- 같은 타입의 빈이 둘 이상 있을때 테스트
-
- BeanFactory
- 스프링 컨테이너의 최상위 인터페이스
- 스프링 빈을 관리하고 조회하는 역할을 담당한다.
- 'getBean()'을 제공
- 지금까지 공부했던 대부분의 기능은 BeanFactory가 제공하는 기능이다.
-
- ApplicationContext
- BeanFactory의 기능을 모두 상속받는다.(BeanFactory를 직접 사용할 일은 거의 없다.)
- ApplicationContext가 상속받는 인터페이스들
- MessageSource(한국에서 들어오면 한국어로, 영어권에서 들어오면 영어로 출력)
- EnvironmentCapable(로컬, 개발, 운영등을 구분해서 처리)
- ApplicationEventPublisher(이벤트를 발행하고 구독하는 모델을 편리하게 지원)
- ResourceLoader(파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회)



// 2021-12-22
-
- 스프링 코드 작성 시작
- 'ApplicationContext' 컨테이너 구성
- @Configuration 어노테이션이 붙은 AppConfig를 구성정보로 사용한다.
- @Bean이 붙은 모든 메서드를 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
- 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다.
- 컨테이너를 구성하기 전까지는 개발자가 필요한 객체를 AppConfig를 사용해서 직접 조회했지만,
  이제부터는 스프링 컨테이너를 통해서 필요한 스프링 객체를 찾아야 한다. (applicationContext.getBean(이름, 클래스))메서드를 사용.
- 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용할 수 있다.

// 2021-12-21
-
- RateDiscountPolicy class 생성
- DiscountPolicy discount = new RateDiscountPolicy();
- 이런 경우는 DIP를 지키고 있다고 볼 수 없다.
- 애플리케이션의 전체 동작 방식을 구성하기 위해, '구현 객체를 생성'하고, '연결'하는 책임을 가지는 별도의 설정 클래스 생성(AppConfig)
- 생성자 주입
- 사용 영역과 구성 영역 구분으로 역할이 뚜렷해짐.

// 2021-12-20
-
- memberServiceTest Junit 테스트
- discount, order 패키지 생성, 인터페이스, 구현체 생성
- OrderServiceTest Junit 테스트


// 2021-12-16 
-

- 프로젝트 생성 
- start.spring.io(jar, dependency X)
- Member



// 비즈니스 요구사항
- 
* 회원 도메인 요구사항
- 회원을 가입하고 조회할 수 있다.
- 회원은 일반과 VIP 두 가지 등급이 있다.
- 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)

* 주문과 할인 정책
- 회원은 상품을 주문할 수 있다.
- 회원 등급에 따라 할인정책을 적용할 수 있다.
- 할인정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라.(나중에 변경 될 수 있다.)
- 할인정책은 변경 가능성이 높다. 회사의 기본 할인정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다.
  최악의 경우 할인을 적용하지 않을 수도 있다.(미확정)

 