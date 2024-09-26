FROM gradle:8.6-jdk21

# 6. 빌드된 JAR 파일을 컨테이너로 복사
ARG JAR_FILE=/build/libs/*-SNAPSHOT.jar

COPY ${JAR_FILE} /testdocker.jar

# 7. 애플리케이션을 실행하는 명령어 지정
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=default", "/testdocker.jar"]