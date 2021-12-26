//2021-12-26
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

 