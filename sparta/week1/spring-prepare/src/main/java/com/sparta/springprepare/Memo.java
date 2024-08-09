package com.sparta.springprepare;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Memo {
    private final String username;
    private String contents;
}

class Main{
    public static void main(String[] args) {
        Memo memo = new Memo("Robbert");
        System.out.println(memo.getUsername());
    }
}
