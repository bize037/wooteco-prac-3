# 기능 목록

## 입력

- [x] **로또 구입 금액 입력**
  - [x] 예외 처리 (String)
    - [x] 문자가 입력된 경우
    - [x] 1,000원 이하인 경우
    - [x] 1,000원 단위가 아닌 경우


- [x] **당첨 번호 입력**
  - [x] 컨트롤러 예외 처리 (List)
    - [x] 리스트 인덱스에 공백이 존재하는 경우
    - [x] 문자가 입력된 경우

  - [x] 도메인(비즈니스 로직) 예외 처리 (List)
    - [x] 1~45에서 벗어난 숫자가 입력된 경우
    - [x] 리스트 길이가 6이 아닌 경우
    - [x] 중복값이 존재하는 경우


- [x] **보너스 번호 입력**
  - [x] 예외 처리 (String)
    - [x] 문자가 입력된 경우
    - [x] 1~45에서 벗어난 숫자가 입력된 경우
    - [x] 당첨 번호 안에 중복된 번호가 존재하는 경우

- [x] 공통 예외 처리 (String)
  - [x] 공백인 경우

## 출력

- [ ] 발행한 로또 수량 및 번호 출력
  - [ ] 오름차순으로 정렬
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```


- [ ] 당첨 내역 출력
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```


- [ ] 수익률 출력
  - 소수점 둘째 자리에서 반올림
    - ex. 100.0%, 51.5%, 1,000,000.0%
```
총 수익률은 62.5%입니다.
```


## 기타

### 로또 규칙
```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

### 최종 실행 결과 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```


### 예외 처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생, 에러 문구 출력
- 단, 에러 문구는 "[ERROR]"로 시작
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```


### domain
- Buyer (Ticket 포함)
  - 로또 구매량
- Ticket
  - 구매한 티켓의 로또 번호
- Lotto
  - 로또 번호
- Bonus
  - 보너스 번호
- Referee
  - 점수 계산
  - 등수 판단
    - enum(Place) : 출력 메시지, 리스트 인덱스 번호, 점수 기준, 상금
  - 수익률 판단


### 계산 세부 설계
#### Referee
- 수행 작업 : 점수 계산, 등수 판단, 수익률 판단
- 제공 정보 : 티켓들 번호들, 로또 당첨 번호들, 보너스 번호
- 세부 설계
```
// 계산 시
placePoints = new ArrayList<>(Collections.nCopies(5, 0))
int totalPrize = 0
for 티켓들 번호들 : 티켓 번호들
  point = 0
  removeAll 티켓 번호들.로또 당첨 번호들
  point += 남은 티켓 번호들 개수
  if 보너스 번호 in 남은 티켓 번호들
    point += 0.5
  if point >= Place.point
    int index = Place.point에 해당하는 Place.listIndex
    placePoints.set(index, placePoints.get(index) + 1)
    int prize += Place.point에 해당하는 Place.cashPrize

// 출력 시
for Place place : Place.values()
  print String.format(place.message, placePoints[place.listIndex])
  
int prizeRate = totalPrize / 100
print String.format("수익률은 %d%입니다.", prizeRate)
```






















