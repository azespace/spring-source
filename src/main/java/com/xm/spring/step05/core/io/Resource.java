package com.xm.spring.step05.core.io;

import java.io.InputStream;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/08/22
 * Description: 资源获取接口，通过该接口可以获取到资源的输入流
 **/
public interface Resource {
    /**
     * 获取输入流
     * @return
     * @throws Exception
     */
    InputStream getInputStream() throws Exception;
}
