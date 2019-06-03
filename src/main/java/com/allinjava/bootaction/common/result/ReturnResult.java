package com.allinjava.bootaction.common.result;

import com.allinjava.bootaction.common.enums.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * layui分页返回实体 接口返回
 *
 * @author: yuhang
 * @date: 2018/8/31
 */
@Data
@Accessors(chain = true)
@ApiModel(value="ReturnResult", description="返回结果")
public class ReturnResult<T> implements Serializable {

    private static final long serialVersionUID = -5061242067855702147L;

    /**
     * 返回码
     */
    @ApiModelProperty(value = "返回码")
    private Integer code;
    /**
     * 返回消息
     */
    @ApiModelProperty(value = "返回描述")
    private String msg;

    /**
     * 详细信息
     */
    @ApiModelProperty(value = "返回详细信息")
    private String desc;
    /**
     * 返回条数
     */
    @ApiModelProperty(value = "返回数据条数")
    private Long count;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private T data;

    public ReturnResult(){}

    public ReturnResult(Integer code,String msg,Long count,T data,String desc){
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
        this.desc = desc;
    }

    public ReturnResult(Integer code,String msg,Long count,T data){
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public ReturnResult(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.count = 1L;
        this.data = data;
    }

    public ReturnResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
        this.count = 0L;
        this.data = null;
    }

    private ReturnResult(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ReturnResult(ResultEnum resultEnum,Long count,T data,String desc){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.count = count;
        this.data = data;
        this.desc = desc;
    }

    public ReturnResult(ResultEnum resultEnum,Long count,T data){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.count = count;
        this.data = data;
    }

    public ReturnResult(ResultEnum resultEnum,T data){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.count = 1L;
        this.data = data;
    }

    private ReturnResult(HttpStatus status){
        this.code = status.value();
        this.msg = status.getReasonPhrase();
    }

    private ReturnResult(HttpStatus status,Long count,T data,String desc){
        this.code = status.value();
        this.msg = status.getReasonPhrase();
        this.count = count;
        this.data = data;
        this.desc = desc;
    }

    private ReturnResult(HttpStatus status,Long count,T data){
        this.code = status.value();
        this.msg = status.getReasonPhrase();
        this.count = count;
        this.data = data;
    }

    private ReturnResult(HttpStatus status,T data){
        this.code = status.value();
        this.msg = status.getReasonPhrase();
        this.count = 1L;
        this.data = data;
    }


    public static <T> ReturnResult<T> success(){
        return new ReturnResult<T>(HttpStatus.OK);
    }

    public static <T> ReturnResult<T> success(T data){
        return new ReturnResult<T>(HttpStatus.OK,data);
    }

    public static <T> ReturnResult<T> success(T data,Long count){
        return new ReturnResult<T>(HttpStatus.OK,count,data);
    }

    public static <T> ReturnResult<T> success(T data,Long count,String desc){
        return new ReturnResult<T>(HttpStatus.OK,count,data,desc);
    }

    public static <T> ReturnResult<T> error(){
        return new ReturnResult<T>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ReturnResult<T> error(HttpStatus status){
        return new ReturnResult<T>(status);
    }

    public static <T> ReturnResult<T> error(ResultEnum status){
        return new ReturnResult<T>(status);
    }
}
