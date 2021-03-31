
module JK(Q,j,k,setn,resetn,clock);

input clock,setn,resetn,j,k;
output reg Q;

always @(posedge clock)
begin
	if(resetn==0)
		Q<=0;
	else if (setn==0)
		Q<=1; 
	else if (j==0 && k==0)
		Q<=Q;
	else if (j==0 && k==1)
		Q<=0;
	else if (j==1 && k==0)
		Q<=1;
	else if (j==1 && k==1)
		Q<=~Q;		
end
endmodule

module mod13_counter(Q,Setn, Resetn, Clock);  
	input Setn, Resetn, Clock;       
	output [3:0] Q;			
	reg high;			      

	initial
		high = 1;		      

	JK JKFF3(Q[3],(Q[2]&Q[1]&Q[0]),Q[2],Setn,Resetn,Clock);
	JK JKFF2(Q[2],(Q[1]&Q[0]),((Q[1]&Q[0])|Q[3]) ,Setn, Resetn, Clock);
	JK JKFF1(Q[1], Q[0],Q[0], Setn, Resetn, Clock);
	JK JKFF0(Q[0],~Q[3]|~Q[2], high, Setn, Resetn, Clock);

endmodule

module Traffic_signal(EW_G,EW_Y,EW_R,NS_G,NS_Y,NS_R,Q,Switch,Setn,Resetn,Clock);
	input Switch,Setn,Resetn,Clock;		
	output [3:0] Q;			
	output reg EW_G,EW_Y,EW_R,NS_G,NS_Y,NS_R;		
	
	initial
   	begin
	  NS_G=1;
	  NS_Y=0;
	  NS_R=0;	
	  EW_G=0;
	  EW_Y=0;
	  EW_R=1;
   	end

	mod13_counter mod13(Q,Setn,Resetn,Clock);

	always @(posedge Clock)   
	begin
	
	if(Switch==0&&Q==4'b0000)
      		begin
		 NS_G=1;
		 NS_Y=0;
		 NS_R=0;	
		 EW_G=0;
		 EW_Y=0;
		 EW_R=1;
  		end

	else
		begin
		 NS_G=(~Q[3]&~Q[1])|(~Q[3]&~Q[2]);
		 NS_Y=Q[2]&Q[1];
		 NS_R=Q[3];	
		 EW_G=(Q[3]&~Q[2]&~Q[1])|(Q[3]&~Q[2]&~Q[0]);
		 EW_Y=(Q[3]&Q[2])|(Q[3]&Q[1]&Q[0]);
		 EW_R=~Q[3];
		end
		
	end
	


endmodule
