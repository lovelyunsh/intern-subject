# Intern Subject

구현 기능
- Spring Security
  - 회원가입
  - 로그인
  - 멤버 정보 확인

## 기본 설정

application.yml 안의 h2 데이터 베이스 url 설정 필요

DB) Roles 테이블 기본 데이터 필요

```sql
insert into roles values (1,'ROLE_USER');
insert into roles values (2,'ROLE_ADMIN');
```

### swagger-ui
http://localhost:8080/swagger-ui/index.html
