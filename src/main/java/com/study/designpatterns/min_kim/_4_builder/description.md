### 객체 생성 패턴: 빌더 패턴 (Builder Pattern)

#### 빌더 패턴 이란?
- 하나의 인스턴스가 다양한 구성으로 생성될 수 있을 때 다양한 구성을 동일한 프로세스로 생성할 수 있도록 지원해주는 패턴이다.
- 빌더 패턴은 생성해야 하는 객체가 Optional한 필드를 많이 가질 수록 유용하게 사용할 수 있다.

#### 다양한 TourPlan을 구성해야 할 때 
*빌더 패턴 적용 전*
- 아래 코드는 인스턴스의 데이터를 setter로 구성하게 되는데, 그렇게 할 경우 불완전한 인스턴스가 생성될 가능성이 있고, 불변 객체로 정의할 수 없다는 단점이 있다.
  

    TourPlan longBeachTrip = new TourPlan();
    longBeachTrip.setTitle("오레곤 롱비치 여행");
    longBeachTrip.setStartDate(LocalDate.of(2022, 4, 19));

    TourPlan cancunTrip = new TourPlan();
    cancunTrip.setTitle("칸쿤 여행");
    cancunTrip.setStartDate(LocalDate.of(2022, 4, 19));
    cancunTrip.setNights(3);
    cancunTrip.setDays(4);
    cancunTrip.setWhereToStay("칸쿤 호텔");
    cancunTrip.addPlan(0, "체크인");
    cancunTrip.addPlan(0, "저녁 식사");
    cancunTrip.addPlan(1, "해변가 산책");
    cancunTrip.addPlan(2, "체크아웃");


- 생성자를 이용해서 데이터를 구성할 경우 각각의 구성 마다 TourPlan의 생성자를 정의해줘야 하고, 특정 멤버 변수의 데이터가 필요하지 않을 경우 명시적으로 null을 넣어줘야 하는 단점이 있다.


    TourPlan longBeachTrip2 = new TourPlan("오레곤 롱비치 여행", LocalDate.of(2022, 4, 19));

    TourPlan cancunTrip2 = new TourPlan("칸쿤 여행", 3, 2, LocalDate.of(2022, 4, 19), "리조트", null);


*빌더 패턴 적용 후*
- TourPlan은 모든 인자를 받는 생성자를 하나만 정의하고 빌더 패턴을 적용해서 결과적으로 동일한 프로세스로 필요한 데이터만 주입된 인스턴스를 생성할 수 있다.


    TourPlan cancunTrip = builder
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 4, 19))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .addPlan(2, "체크아웃")
                .getPlan();

    TourPlan longBeachTrip = builder
            .title("롱비치")   
            .startDate(LocalDate.of(2022, 4, 19))
            .getPlan();


#### Director 사용하기

- TourPlan의 다양한 구성에 대해서 Director 클래스에 미리 정의해 놓고 사용할 수 있다.


    public class TourDirector {
    
        private final TourPlanBuilder tourPlanBuilder;
    
        public TourDirector(TourPlanBuilder tourPlanBuilder) {
            this.tourPlanBuilder = tourPlanBuilder;
        }
    
        public TourPlan cancunTrip() {
            return tourPlanBuilder
                    .title("칸쿤 여행")
                    .nightsAndDays(2, 3)
                    .startDate(LocalDate.of(2022, 4, 19))
                    .whereToStay("리조트")
                    .addPlan(0, "체크인")
                    .addPlan(1, "저녁식사")
                    .addPlan(2, "체크아웃")
                    .getPlan();
        }
    
        public TourPlan longBeachTrip() {
            return tourPlanBuilder
                    .title("롱비치")
                    .startDate(LocalDate.of(2022, 4, 19))
                    .getPlan();
        }
    }


    TourDirector tourDirector = new TourDirector(new DefaultTourPlanBuilder());
    TourPlan cancunTrip1 = tourDirector.cancunTrip();
    TourPlan longBeachTrip1 = tourDirector.longBeachTrip();


#### 빌더 패턴의 장단점
- 장점
  - 빌더를 잘 설계한다면 복잡한 객체를 생성해야할 때, 순차적인 프로세스로 만들 수 있게 강제할 수 있다.
  - 객체를 생성하는 복잡한 과정을 Director를 통해서 숨길 수 있다.
  - 불완전한 객체를 생성할 수 없도록 강제할 수 있다.
    - ex) getPlan() 메서드 안에서 데이터 검증
- 단점
  - 실제 사용할 객체를 생성하기 전에 Builder와 Director 인스턴스를 먼저 생성해야 하기 때문에 복잡성이 증가할 수 있다.