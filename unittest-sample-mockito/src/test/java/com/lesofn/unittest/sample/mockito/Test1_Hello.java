package com.lesofn.unittest.sample.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

/**
 * @author sofn
 * @date 2022-05-17 20:02
 */

public class Test1_Hello {

    @Test
    void helloMock() {
        // 构建mock数据
        List<String> list = mock(List.class);
        list.add("1");
        list.add("2");

        // 会得到null ，前面只是在记录行为而已，没有往list中添加数据
        assertNull(list.get(0));

        verify(list).add("1"); // 正确，因为该行为被记住了
        // verify(list).add("3"); // 报错，因为前面没有记录这个行为
    }



}
