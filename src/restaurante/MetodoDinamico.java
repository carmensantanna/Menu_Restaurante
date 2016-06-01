/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;

/**
 *
 * @author Carmen
 */
public class MetodoDinamico implements IMetodo {

    private double lucroMax;

    public ArrayList<Prato> calculaLucro(Menu menu) {
        int days = menu.getQuantDias();
        int budget = (int) menu.getOrcamento();
        int N = menu.getNumPratos();
        int[] cost = new int[N];
        int[] ben = new int[N];
        Prato[] pratos = menu.getPratos();
        ArrayList<Prato> pratosLucro = new ArrayList<Prato>();
        
        for(int i = 0; i < pratos.length; i++)
        {
            cost[i] = (int) pratos[i].getCusto();
            ben[i] = (int) pratos[i].getLucro();
        }

        // ans[daysleft][budgetleft][yesterday][doubleormore]
        double[][][][] ans = new double[days][budget + 1][N][2];
        // ans[x][y][z][c] = sum over all items of ans[x-1][y-cost][i][0 or
        // 1 depending]
        for (int i = 0; i <= budget; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    ans[0][i][j][k] = 0;
                }
            }
        }
        for (int i = 1; i < days; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    ans[i][0][j][k] = -1;
                }
            }
        }

        for (int i = 1; i < days; i++) {
            for (int j = 1; j <= budget; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < 2; l++) {
                        ans[i][j][k][l] = -1;
                        for (int item = 0; item < N; item++) {
                            if (cost[item] > j) {
                                continue;
                            }
                            double next = ans[i - 1][j - cost[item]][item][k == item ? 1 : 0];
                            if (next < -0.5) {
                                continue;
                            }
                            double b = 0;
                            if (k == item) {
                                if (l == 1) {
                                    b = 0;
                                } else if (l == 0) {
                                    b = 0.5 * ben[item];
                                }
                            } else {
                                b = ben[item];
                            }
                            if (next + b > ans[i][j][k][l]) {
                                ans[i][j][k][l] = next + b;
                            }
                        }
                    }
                }
            }
        }

        int[] items = new int[days];

        double[] finans = new double[budget + 1];
        finans[0] = 0;
        for (int i = 1; i <= budget; i++) {
            for (int item = 0; item < N; item++) {
                if (cost[item] > i) {
                    continue;
                }
                if (ans[days - 1][i - cost[item]][item][0] < 0) {
                    continue;
                }
                double poss = ben[item] + ans[days - 1][i - cost[item]][item][0];
                if (poss > finans[i]) {
                    finans[i] = poss;
                }
            }
        }
        double best = finans[budget];

        while (budget > 0 && Math.abs(finans[budget - 1] - finans[budget]) < 1E-6) {
        //while (budget > 0 && Math.abs(finans[budget - 1] - finans[budget]) < 0.000001) {
            budget--;
        }
        //System.out.printf("%.1f\n", best);
        if (best <= 0) {
            for (int item = 0; item < N; item++) {
                if (cost[item] > budget) {
                    continue;
                }
                if (ans[days - 1][budget - cost[item]][item][0] < 0) {
                    continue;
                }
                double poss = ben[item] + ans[days - 1][budget - cost[item]][item][0];
                if (Math.abs(poss - best) < 1e-6) {
                    items[0] = item;
                    break;
                }
            }
        }
        double cur = cost[items[0]];

        int curi = days - 1, curj = budget - cost[items[0]], curk = items[0], curl = 0;
        while (curi > 0 && curj > 0) {
            for (int item = 0; item < N; item++) {
                if (cost[item] > curj) {
                    continue;
                }
                double next = ans[curi - 1][curj - cost[item]][item][curk == item ? 1 : 0];
                if (next < -0.5) {
                    continue;
                }
                double b = 0;
                if (curk == item) {
                    if (curl == 1) {
                        b = 0;
                    } else if (curl == 0) {
                        b = 0.5 * ben[item];
                    }
                } else {
                    b = ben[item];
                }
                if (Math.abs(next + b - ans[curi][curj][curk][curl]) < 1E-6) {
                //if (Math.abs(next + b - ans[curi][curj][curk][curl]) < 0.000001) {
                    cur += b;
                    items[days - curi] = item;
                    curi--;
                    curj -= cost[item];
                    curl = (curk == item ? 1 : 0);
                    curk = item;
                    break;
                }
            }
        }
        
        lucroMax = best;
        
        for(int i = 0; i < items.length; i++)
        {
            Prato prato = menu.getPrato(items[i] + 1);
            if(prato != null)
                pratosLucro.add(prato);
        }
        
        return pratosLucro;
    }

    public double getLucroMax() {
        return lucroMax;
    }
    
    
}
