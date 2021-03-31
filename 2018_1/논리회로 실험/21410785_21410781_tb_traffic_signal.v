
`timescale 10ps/1ps
module tb_Traffic_signal;

	reg Switch,Setn,Resetn,Clock;  
	
	wire [3:0] Q;		       
	wire EW_G,EW_Y,EW_R,NS_G,NS_Y,NS_R;
	
	Traffic_signal test(EW_G,EW_Y,EW_R,NS_G,NS_Y,NS_R,Q,Switch,Setn,Resetn,Clock);

	initial
	begin
		
		Switch<=1;
		Setn <= 1;
		Resetn <= 0;
		Clock <= 0;

		#1 Resetn <= 1;
		#40 Switch <= 0;
		#40 Switch <= 1;
	end
 
	always
		#1 Clock = ~Clock;

	always
	begin
		if(Switch==0&&Q==4'b0000) 
			#1 Resetn<=0;
		else                       
			#1 Resetn<=1;
	end

	
endmodule
