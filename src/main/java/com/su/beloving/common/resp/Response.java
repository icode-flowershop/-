package com.su.beloving.common.resp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonPropertyOrder({"code","msg"})
public class Response implements Cloneable{
    /**
     * 返回码
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;

    @SneakyThrows
    public Response clone(){
        return (Response) super.clone();
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
