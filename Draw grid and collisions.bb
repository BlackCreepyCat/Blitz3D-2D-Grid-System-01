Graphics 640,480,32,2
SetBuffer BackBuffer()

Dim map(19,19)

Global px=20
Global py=20
Global gpx,gpy
Global touch=False


readmap()

While Not KeyHit(1)
	Cls
	
	drawmap()
	checkmove()
	drawsurround()
	drawplayer()
	showstats()
	
	Flip
Wend
End


; FUNCTIONS

; Draw Surround
Function drawsurround()
	For x=-1 To 1
		For y=-1 To 1
			If map(gpx+x,gpy+y)=1
				Color 255,255,0
				If RectsOverlap (px,py,20,20,((px/20)*20)+x*20,((py/20)*20)+y*20,20,20)
					touch =True
				Else
					touch =False
				EndIf
				Rect ((px/20)*20)+x*20,((py/20)*20)+y*20,20,20,touch
				Color 255,255,255
			End If
		Next
	Next
End Function

; Show Stats
Function showstats()
	Text 430,10,"Grid Ref: "+gpx+","+gpy
	
	Text 430,30,map(gpx-1,gpy-1)+" "+map(gpx,gpy-1)+" "+map(gpx+1,gpy-1)
	Text 430,40,map(gpx-1,gpy)+" "+map(gpx,gpy)+" "+map(gpx+1,gpy)
	Text 430,50,map(gpx-1,gpy+1)+" "+map(gpx,gpy+1)+" "+map(gpx+1,gpy+1)
	
End Function

; Check Move
Function checkmove()
	
	ox=px
	oy=py
	
	If KeyDown(205)
		px=px+2
	End If
	
	If KeyDown(203)
		px=px-2
	End If
	
	If KeyDown(200)
		py=py-2
	End If
	
	If KeyDown(208)
		py=py+2
	End If
	
	If px>360 Or px<20 Then px=ox
	If py>360 Or py<20 Then py=oy
	
	gpx=px/20
	gpy=py/20
	
End Function

; Draw Player
Function drawplayer()
	Rect px,py,20,20
End Function

; Draw Map
Function drawmap()
	For ac=0 To 19
		For dn=0 To 19
			Color 0,0,255
			If map(ac,dn)=1 Then Rect ac*20,dn*20,20,20
			Color 0,255,0
			Line ac*20,0,ac*20,400
			Line 0,dn*20,400,dn*20
			Color 255,255,255
		Next
	Next
End Function

; Read Map
Function readmap()
	Restore level1
	For dn=0 To 19
		For ac=0 To 19
			Read a
			map(ac,dn)=a
		Next
	Next
End Function

.level1
Data 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1
Data 1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
Data 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1

;~IDEal Editor Parameters:
;~C#Blitz3D