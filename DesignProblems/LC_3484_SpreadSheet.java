// LC_3484
// this is not the most optimal code 
class Spreadsheet {
    int[][] sheet ;
    public Spreadsheet(int rows) {
        this.sheet = new int[26][rows];
        for(int i=0; i<26; i++){
            for(int j=0; j<rows; j++){
                sheet[i][j] = 0;
            }
        }
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[col][row] = value;        
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[col][row] = 0;   
    }
    
    public int getValue(String formula) {
        int result = 0;
        formula = formula.substring(1);
        String[] eq = formula.split("\\+");

        for(int i=0; i<eq.length; i++){
            if(!eq[i].matches("\\d+")){
                int col = eq[i].charAt(0) - 'A';
                int row =  Integer.parseInt(eq[i].substring(1)) - 1;
                result += sheet[col][row];
            }
            else{
                result += Integer.parseInt(eq[i]);
            }
        }
        return result;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
