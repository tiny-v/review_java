package com.my.pattern.builder.demo;

/**
 * @author mayue
 */
public class VirtualMachine {

    private String id;
    /**
     * 虚机名称
     */
    private String name;
    /**
     * 虚机状态
     */
    private VmStatus vmStatus;
    /**
     * 虚机任务状态
     */
    private VmTaskStatus vmTaskStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VmStatus getVmStatus() {
        return vmStatus;
    }

    public void setVmStatus(VmStatus vmStatus) {
        this.vmStatus = vmStatus;
    }

    public VmTaskStatus getVmTaskStatus() {
        return vmTaskStatus;
    }

    public void setVmTaskStatus(VmTaskStatus vmTaskStatus) {
        this.vmTaskStatus = vmTaskStatus;
    }

    public enum VmTaskStatus {
        /**
         * 创建中
         */
        Creating,

        /**
         * 开机中
         */
        Starting,

        /**
         * 关机中
         */
        Stopping,
        /**
         * 暂停中
         */
        Pausing,
        /**
         * 无任务
         */
        None
    }

    public enum VmStatus {
        /**
         * 开机
         */
        Start,
        /**
         * 关机
         */
        Stop,
        /**
         * 异常
         */
        Error,
        /**
         * 资源不存在
         */
        Unknown
    }


}
