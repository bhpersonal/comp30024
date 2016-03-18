package State;

public class Board {
	
	public static final int Untaken = 0;
	
	public static final int TakenByPlayer1 = 1;
	
	public static final int TakenByPlayer2 = 2;
	
	public int hexCount; // prob faster than HexStates.Length
	
	public int edgeCount; // prob faster than EdgeStates.Length
	
	public byte[] hexStates;
	
	public byte[] edgeStates;
	
	public byte[][] hexEdgesIndexes;
	
	public byte[][] edgeHexesIndexes;
	
	public Board(int dimension)
	{
		// TODO initialize hexCount, edgeCount, hexStates, edgeStates, hexEdges, edgeHexes
		
		
	}
	
	public Board clone()
	{
		// TODO copy state & return new board
		return null;
	}
	
	public void makeMove(byte player, int edgeIndex)
	{
		edgeStates[edgeIndex] = player;
		
		// Has captured either adjacent hex?
		for (int checkHexIndex : edgeHexesIndexes[edgeIndex])
		{
			if (hexStates[checkHexIndex] != Untaken) continue;
			
			boolean hasEmptyEdge = false;
			for (int checkEdgeIndex : hexEdgesIndexes[checkHexIndex])
			{
				if (edgeStates[checkEdgeIndex] == Untaken)
				{
					hasEmptyEdge = true;
					break;
				}
			}
			
			if (!hasEmptyEdge)
			{
				// Successful capture of this hex!
				hexStates[checkHexIndex] = player;
			}
		}
	}
}
