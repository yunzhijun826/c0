
package Analyser;

import instruction.FnInstruction;
import instruction.Instruction;
import instruction.Operation;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class out {
    public static void Out(String name, ArrayList<String> global, ArrayList<FnInstruction> fnList) throws Exception{
        FileOutputStream f = new FileOutputStream(new File(name));
        int size=global.size();
        f.write(intToByte(0x72303b3e));
        f.write(intToByte(0x1));
        f.write(intToByte(size));
        for(int i = 0; i < size; i ++){ //全局
            if(global.get(i).equals("1")){
                f.write(0);
                f.write(intToByte(8));
                f.write(longToByte(0L));
            }else if(global.get(i).equals("0")){
                f.write(1);
                f.write(intToByte(8));
                f.write(longToByte(0L));
            }
            else{ //函数名、字符串
                f.write(1);
                f.write(intToByte(global.get(i).length()));
                f.write(global.get(i).getBytes());
            }
        }
        int size2=fnList.size()
        f.write(intToByte(size2));// functions.count

        for(int i = 0; i < size2; i ++){ //function
            f.write(intToByte(fnList.get(i).getName()));
            f.write(intToByte(fnList.get(i).getRet_slots()));
            f.write(intToByte(fnList.get(i).getParam_slots()));
            f.write(intToByte(fnList.get(i).getLoc_slots()));
            f.write(intToByte(fnList.get(i).getBodyCount()));

            ArrayList<Instruction> fninstructions = fnList.get(i).getBodyItem();
            int size3=fninstructions.size();
            for(int j = 0; j < size3; j ++){
                f.write(fninstructions.get(j).getOpt().getI());
                if(fninstructions.get(j).getValue() != null){ //有操作数
                    if(fninstructions.get(j).getOpt() == Operation.push){ //是push
                        f.write(longToByte((long)fninstructions.get(j).getValue()));
                    }
                    else{
                        f.write(intToByte((int)fninstructions.get(j).getValue()));
                    }
                }
            }
        }
    }

    public static byte[] intToByte(int val) {
        byte[] b = new byte[4];
        b[0] = (byte) ((val >> 24) & 0xff);
        b[1] = (byte) ((val >> 16) & 0xff);
        b[2] = (byte) ((val >> 8) & 0xff);
        b[3] = (byte) (val & 0xff);
        return b;
    }

    public static byte[] longToByte(long val) {
        byte[] b = new byte[8];
        b[0] = (byte) ((val >> 56) & 0xff);
        b[1] = (byte) ((val >> 48) & 0xff);
        b[2] = (byte) ((val >> 40) & 0xff);
        b[3] = (byte) ((val >> 32) & 0xff);
        b[4] = (byte) ((val >> 24) & 0xff);
        b[5] = (byte) ((val >> 16) & 0xff);
        b[6] = (byte) ((val >> 8) & 0xff);
        b[7] = (byte) (val & 0xff);
        return b;
    }

}
