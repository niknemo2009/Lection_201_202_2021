package Lection_050321;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleTest {

    @BeforeAll
    static void ficstureClassStart(){
        System.out.println("BeforeAll");
    }
    @AfterAll
    static void ficstureClassFinish(){
        System.out.println("AfterAll");
    }
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void convertBall(int ball,int expResult) {
       // Exam[] mod=new Model1();
        //int actualResult=mod.convertBall(ball);
       // assertEquals(expResult,actualResult);
    }

    static Stream<Arguments> generateData(){

        return Stream.of(
                Arguments.of(35,2),
                Arguments.of(59,2),
                Arguments.of(60,3),
                Arguments.of(61,3),
                Arguments.of(70,3),
                Arguments.of(74,3),
                Arguments.of(75,4),
                Arguments.of(76,4),
                Arguments.of(80,4),
                Arguments.of(89,4),
                Arguments.of(90,5),
                Arguments.of(91,5)


        );
    }

    @org.junit.jupiter.api.Test
    void convertBall23() {
    }
}