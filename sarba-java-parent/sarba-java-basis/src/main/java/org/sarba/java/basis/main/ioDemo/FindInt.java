package org.sarba.java.basis.main.ioDemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-14 11:50
 * @description:
 **/
public class FindInt {

    private Path file;

    public FindInt(Path file) {
        this.file = file;
    }

    public int seek() throws IOException {
        int num = -1;
        SeekableByteChannel channel = Files.newByteChannel(file);
        ByteBuffer byteBuffer  = ByteBuffer.allocate(8);
        channel.read(byteBuffer);
        long offset = byteBuffer.getLong(0);
        channel.position(offset);
        byteBuffer.rewind();
        channel.read(byteBuffer);
        num = byteBuffer.getInt(0);
        return num;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("datafile");
        int num = new FindInt(path).seek();
        System.out.println(num);
    }
}
