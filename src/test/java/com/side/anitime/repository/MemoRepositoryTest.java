package com.side.anitime.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

//    @Test
//    public void InsertDummies(){
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            Memo memo = Memo.builder()
//                    .memoText("Sample..." + i)
//                    .build();
//
//            memoRepository.save(memo);
//        });
//    }

    @Test
    public void SelectDummies(){
        Long id = 10L;
        Optional<Memo> result = memoRepository.findById(id);

        System.out.println("------------------------------------");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }
}