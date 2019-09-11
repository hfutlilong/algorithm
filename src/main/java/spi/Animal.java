package spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Animal {
    void sayHello();
}
