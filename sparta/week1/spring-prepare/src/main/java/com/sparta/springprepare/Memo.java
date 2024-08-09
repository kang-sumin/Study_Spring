package com.sparta.springprepare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    private String username;
    private String contents;
}

class Main{
    public static void main(String[] args) {
        Memo memo = new Memo("Robbert", "내용");
        memo.setUsername("Kate");
        System.out.println(memo.getUsername());
    }
}
