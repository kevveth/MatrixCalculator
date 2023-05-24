package cisc191.sdmesa.edu;

import java.util.ArrayList;

public class Matrix
{
	private ArrayList<ArrayList<Double>> matrix;

	public Matrix(ArrayList<ArrayList<Double>> matrix)
	{
		this.matrix = matrix;
	}

	public int getRows()
	{
		return matrix.size();
	}

	public int getColumns()
	{
		return matrix.get(0).size();
	}

	public double getElement(int row, int column)
	{
		return matrix.get(row).get(column);
	}

	public void setElement(int row, int column, double element)
	{
		matrix.get(row).set(column, element);
	}

	public void rowReduce()
	{
		int numRows = getRows();
		int numColumns = getColumns();

		int lead = 0;
		for (int row1 = 0; row1 < numRows; row1++)
		{
			if (lead >= numColumns)
			{
				return;
			}
			int row2 = row1;
			while (matrix.get(row2).get(lead) == 0)
			{
				row2++;
				if(row2 == numRows)
				{
					row2 = row1;
					lead++;
					if(lead == numColumns)
					{
						return;
					}
				}
			}
			
			// Swap row1 and row2
			ArrayList<Double> temp = matrix.get(row2);
			matrix.set(row2, matrix.get(row1));
			matrix.set(row1, temp);
			
		}
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (ArrayList<Double> row : matrix)
		{
			for (double element : row)
			{
				sb.append(element).append(" ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
