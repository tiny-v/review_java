package com.my.pattern.builder.demo;

/**
 * @author mayue
 * 使用构建者模式，写个链式验证的demo
 */
public class ValidatorBuilder {


    private VirtualMachine vm;

    private Boolean validateResult = true;

    public ValidatorBuilder(VirtualMachine vm){
        this.vm = vm;
    }

    /**
     * 验证虚机状态, 匹配其中一个参数状态
     * @param vmStatusList
     * @return
     */
    public ValidatorBuilder validateVmStatusMatched(VirtualMachine.VmStatus... vmStatusList){
        if(validateResult){
            validateResult = false;
            for(VirtualMachine.VmStatus vmStatus: vmStatusList){
                if (vm.getVmStatus().equals(vmStatus)) {
                    validateResult = true;
                    break;
                }
            }
        }
        return this;
    }

    /**
     * 验证虚机状态， 不匹配任何一个参数状态
     * @param vmStatusList
     * @return
     */
    public ValidatorBuilder validateVmStatusNotMatched(VirtualMachine.VmStatus... vmStatusList){
        if(validateResult){
            for(VirtualMachine.VmStatus vmStatus: vmStatusList){
                if (vm.getVmStatus().equals(vmStatus)) {
                    validateResult = false;
                    logVmStatusNotMatchedError(vmStatus, vm.getId());
                    return this;
                }
            }
        }
        return this;
    }



    public void validateVmStatus(VirtualMachine.VmStatus vmStatus) {
        if (validateResult && !vm.getVmStatus().equals(vmStatus)) {
            validateResult = false;
            logVmStatusMatchedError(vmStatus, vm.getId());
        }
    }

    /**
     * 验证虚机任务状态
     * @param vmTaskStatus
     * @return
     */
    public ValidatorBuilder validateVmTaskStatus(VirtualMachine.VmTaskStatus vmTaskStatus){
        if(validateResult && !vm.getVmTaskStatus().equals(vmTaskStatus)){
            validateResult = false;
        }
        return this;
    }

    public Boolean validate(){
        return validateResult;
    }

    /**
     * 打印虚机状态错误日志， 后可用抛出异常替代
     * @param vmStatus
     */
    private void logVmStatusMatchedError(VirtualMachine.VmStatus vmStatus, String vmId){
        switch (vmStatus){
            case Start:
                System.out.println("虚机必须是开机状态, vmId:"+vmId);
                break;
            case Stop:
                System.out.println("虚机必须是关机状态, vmId:"+vmId);
                break;
            default:
                break;
        }
    }

    private void logVmStatusNotMatchedError(VirtualMachine.VmStatus vmStatus, String vmId){
        switch (vmStatus){
            case Start:
                System.out.println("虚机不能是开机状态, vmId:"+vmId);
                break;
            case Stop:
                System.out.println("虚机不能是关机状态, vmId:"+vmId);
                break;
            default:
                break;
        }
    }

    private void logVmTaskStatusError(){

    }

    public static void main(String[] args){
        // 构造一个虚机
        VirtualMachine virtualMachine = new VirtualMachine();
        virtualMachine.setId("mockVmId");
        virtualMachine.setName("my");
        virtualMachine.setVmStatus(VirtualMachine.VmStatus.Start);
        virtualMachine.setVmTaskStatus(VirtualMachine.VmTaskStatus.Stopping);
        // 验证虚机状态
        Boolean result = new ValidatorBuilder(virtualMachine)
                // 虚机必须是开机或关机状态
                .validateVmStatusNotMatched(VirtualMachine.VmStatus.Start, VirtualMachine.VmStatus.Stop)
                .validateVmTaskStatus(VirtualMachine.VmTaskStatus.Stopping).validate();
        System.out.println(result);
    }



}
