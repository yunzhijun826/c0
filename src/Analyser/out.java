package Analyser;

import instruction.FnInstruction;
import instruction.Instruction;
import instruction.Operation;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class out {
    public static void Out(String name, ArrayList<String> global_v, ArrayList<FnInstruction> fn_list) throws Exception{
        FileOutputStream file = new FileOutputStream(new File(name));
        file.write(intToByte(0x72303b3e));
        file.write(intToByte(0x1));
        file.write(intToByte(global_v.size()));
        int globalSize=global_v.size();
        for(int i = 0; i < globalSize; i ++){ //全局
            if(global_v.get(i)=="1"){
                file.write(0);
                file.write(intToByte(8));
                file.write(longToByte(0L));
            }else if(global_v.get(i) == "0"){
                file.write(1);
                file.write(intToByte(8));
                file.write(longToByte(0L));
            }
            else{ //函数名、字符串
                file.write(1);
                file.write(global_v.get(i).length());
                file.write(global_v.get(i).getBytes());
            }
        }
        int fn_list_size=fn_list.size();
        file.write(intToByte(fn_list_size));// functions.count

        for(int i = 0; i < fn_list_size; i ++){ //function
            file.write(intToByte(fn_list.get(i).getName()));
            file.write(intToByte(fn_list.get(i).getRet_slots()));
            file.write(intToByte(fn_list.get(i).getParam_slots()));
            file.write(intToByte(fn_list.get(i).getLoc_slots()));
            file.write(intToByte(fn_list.get(i).getBodyCount()));

            ArrayList<Instruction> fn_instructions = fn_list.get(i).getBodyItem();
            int fn_instructionssize=fn_instructions.size();

            for(int j = 0; j < fn_instructionssize; j ++){
                file.write(fn_instructions.get(j).getOpt().getI());
                if(fn_instructions.get(j).getValue() != null){ //有操作数
                    if(fn_instructions.get(j).getOpt() == Operation.push){ //是push
                        file.write(longToByte((long)fn_instructions.get(j).getValue()));
                    }
                    else{
                        file.write(intToByte((int)fn_instructions.get(j).getValue()));
                    }
                }
            }
        }
    }


    public static byte[] intToByte(int val) {
        byte[] b = new byte[4];
        b[3] = (byte) (val & 0xff);
        b[2] = (byte) ((val >> 8) & 0xff);
        b[1] = (byte) ((val >> 16) & 0xff);
        b[0] = (byte) ((val >> 24) & 0xff);
        return b;
    }
    public static byte[] longToByte(long val) {
        byte[] b = new byte[8];
        b[7] = (byte) (val & 0xff);
        b[6] = (byte) ((val >> 8) & 0xff);
        b[5] = (byte) ((val >> 16) & 0xff);
        b[4] = (byte) ((val >> 24) & 0xff);
        b[3] = (byte) ((val >> 32) & 0xff);
        b[2] = (byte) ((val >> 40) & 0xff);
        b[1] = (byte) ((val >> 48) & 0xff);
        b[0] = (byte) ((val >> 56) & 0xff);
        return b;
    }
}
