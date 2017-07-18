package com.jesjobom.websocket;

import com.jesjobom.websocket.stomp.SubscribableChannel;
import com.jesjobom.websocket.stomp.WebsocketClient;
import org.springframework.util.StringUtils;

/**
 *
 * @author jesjobom
 */
public class Main extends javax.swing.JFrame {

	private static final long serialVersionUID = -2725530903813434009L;

	private WebsocketClient client;

	/**
	 * Creates new form Main
	 */
	public Main() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                wsUrlLbl = new javax.swing.JLabel();
                wsUrlTxt = new javax.swing.JTextField();
                wsSendHelloBtn = new javax.swing.JButton();
                wsDisconnectBtn = new javax.swing.JButton();
                wsConnectBtn = new javax.swing.JButton();
                jSeparator1 = new javax.swing.JSeparator();
                chLbl = new javax.swing.JLabel();
                chSel = new javax.swing.JComboBox<>();
                chUnsubscribeBtn = new javax.swing.JButton();
                chSubscribeBtn = new javax.swing.JButton();
                chCreateBtn = new javax.swing.JButton();
                jSeparator2 = new javax.swing.JSeparator();
                inLbl = new javax.swing.JLabel();
                inTxt = new javax.swing.JTextField();
                inSendBtn = new javax.swing.JButton();
                jSeparator3 = new javax.swing.JSeparator();
                outLbl = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                outTxt = new javax.swing.JTextArea();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Websocket Spring Client");
                setResizable(false);

                wsUrlLbl.setText("URL:");

                wsUrlTxt.setText("http://localhost:8080/websocket-spring");

                wsSendHelloBtn.setText("Send Hello");
                wsSendHelloBtn.setEnabled(false);
                wsSendHelloBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                wsSendHelloBtnActionPerformed(evt);
                        }
                });

                wsDisconnectBtn.setText("Disconnect");
                wsDisconnectBtn.setEnabled(false);
                wsDisconnectBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                wsDisconnectBtnActionPerformed(evt);
                        }
                });

                wsConnectBtn.setText("Connect");
                wsConnectBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                wsConnectBtnActionPerformed(evt);
                        }
                });

                chLbl.setText("CH:");

                chSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a channel or create a new one" }));
                chSel.setEnabled(false);
                chSel.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                chSelItemStateChanged(evt);
                        }
                });

                chUnsubscribeBtn.setText("Unsubscribe");
                chUnsubscribeBtn.setEnabled(false);
                chUnsubscribeBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chUnsubscribeBtnActionPerformed(evt);
                        }
                });

                chSubscribeBtn.setText("Subscribe");
                chSubscribeBtn.setEnabled(false);
                chSubscribeBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chSubscribeBtnActionPerformed(evt);
                        }
                });

                chCreateBtn.setText("Create");
                chCreateBtn.setEnabled(false);
                chCreateBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                chCreateBtnActionPerformed(evt);
                        }
                });

                inLbl.setText("IN:");

                inTxt.setToolTipText("Send a message to the chosen channel or use @ to send a private message");
                inTxt.setEnabled(false);

                inSendBtn.setText("Send");
                inSendBtn.setEnabled(false);
                inSendBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                inSendBtnActionPerformed(evt);
                        }
                });

                outLbl.setText("OUT:");

                outTxt.setColumns(20);
                outTxt.setRows(5);
                outTxt.setEnabled(false);
                jScrollPane1.setViewportView(outTxt);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3)
                                        .addComponent(jSeparator2)
                                        .addComponent(jSeparator1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(wsUrlLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wsUrlTxt)
                                                .addGap(18, 18, 18)
                                                .addComponent(wsConnectBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wsDisconnectBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wsSendHelloBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(chLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                                .addComponent(chCreateBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chSubscribeBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chUnsubscribeBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(inLbl)
                                                .addGap(18, 18, 18)
                                                .addComponent(inTxt)
                                                .addGap(18, 18, 18)
                                                .addComponent(inSendBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(outLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(wsUrlLbl)
                                        .addComponent(wsUrlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wsSendHelloBtn)
                                        .addComponent(wsDisconnectBtn)
                                        .addComponent(wsConnectBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chLbl)
                                        .addComponent(chSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chUnsubscribeBtn)
                                        .addComponent(chSubscribeBtn)
                                        .addComponent(chCreateBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inLbl)
                                        .addComponent(inTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inSendBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(outLbl)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	/**
	 * CONNECT button action
	 *
	 * @param evt
	 */
        private void wsConnectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsConnectBtnActionPerformed
		new WebsocketClient(this.wsUrlTxt.getText(), this.outTxt, this.chSel).connect(c -> {
			client = c;
			setWsConnected(true);
		});
        }//GEN-LAST:event_wsConnectBtnActionPerformed

	/**
	 * DISCONNECT button action
	 *
	 * @param evt
	 */
        private void wsDisconnectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsDisconnectBtnActionPerformed
		client.disconnect();
		client = null;
		setWsConnected(false);
        }//GEN-LAST:event_wsDisconnectBtnActionPerformed

	/**
	 * SEND HELLO button action
	 *
	 * @param evt
	 */
        private void wsSendHelloBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsSendHelloBtnActionPerformed
		client.sendHello();
        }//GEN-LAST:event_wsSendHelloBtnActionPerformed

	/**
	 * Channel CREATE button action
	 * 
	 * @param evt 
	 */
        private void chCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chCreateBtnActionPerformed
		client.createChannel();
        }//GEN-LAST:event_chCreateBtnActionPerformed

	/**
	 * Channel Selection action
	 * 
	 * @param evt 
	 */
        private void chSelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chSelItemStateChanged
		if (this.chSel.getSelectedIndex() > 0) {
			SubscribableChannel channel = (SubscribableChannel) this.chSel.getSelectedItem();

			if (channel.getSubscription() == null) {
				this.chSubscribeBtn.setEnabled(true);
				this.chUnsubscribeBtn.setEnabled(false);

			} else {
				this.chSubscribeBtn.setEnabled(false);
				this.chUnsubscribeBtn.setEnabled(true);
			}
		} else {
			this.chSubscribeBtn.setEnabled(false);
			this.chUnsubscribeBtn.setEnabled(false);
		}
        }//GEN-LAST:event_chSelItemStateChanged

	/**
	 * Channel SUBSCRIBE button action
	 * 
	 * @param evt 
	 */
        private void chSubscribeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chSubscribeBtnActionPerformed
		SubscribableChannel channel = (SubscribableChannel) this.chSel.getSelectedItem();
		client.subscribeChannel(channel);
		chSelItemStateChanged(null);
        }//GEN-LAST:event_chSubscribeBtnActionPerformed

	/**
	 * Channel UNSUBSCRIBE button action
	 * 
	 * @param evt 
	 */
        private void chUnsubscribeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chUnsubscribeBtnActionPerformed
                SubscribableChannel channel = (SubscribableChannel) this.chSel.getSelectedItem();
		client.unsubscribeChannel(channel);
		chSelItemStateChanged(null);
        }//GEN-LAST:event_chUnsubscribeBtnActionPerformed

	/**
	 * Text SEND button action
	 * 
	 * @param evt 
	 */
        private void inSendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inSendBtnActionPerformed
		SubscribableChannel channel = null;
                if (this.chSel.getSelectedIndex() > 0) {
			channel = (SubscribableChannel) this.chSel.getSelectedItem();
		}
		
		String text = this.inTxt.getText();
		if(StringUtils.hasText(text)) {
			client.sendChannel(channel, text);
		}
        }//GEN-LAST:event_inSendBtnActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new Main().setVisible(true);
		});
	}

	/**
	 * Controls the visibility of inputs when connected or not 
	 * 
	 * @param connected 
	 */
	private void setWsConnected(boolean connected) {
		this.wsUrlTxt.setEnabled(!connected);
		this.wsConnectBtn.setEnabled(!connected);
		this.wsDisconnectBtn.setEnabled(connected);
		this.wsSendHelloBtn.setEnabled(connected);

		this.chSel.setEnabled(connected);
		this.chCreateBtn.setEnabled(connected);

		this.inTxt.setEnabled(connected);
		this.inSendBtn.setEnabled(connected);

		this.outTxt.setEnabled(connected);
		this.outTxt.setEditable(false);

		if (!connected) {
			for (int i = 1; i < this.chSel.getItemCount(); i++) {
				this.chSel.removeItemAt(i);
			}
			this.chSel.setSelectedIndex(0);
			this.chSubscribeBtn.setEnabled(connected);
			this.chUnsubscribeBtn.setEnabled(connected);
		}
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton chCreateBtn;
        private javax.swing.JLabel chLbl;
        private javax.swing.JComboBox<String> chSel;
        private javax.swing.JButton chSubscribeBtn;
        private javax.swing.JButton chUnsubscribeBtn;
        private javax.swing.JLabel inLbl;
        private javax.swing.JButton inSendBtn;
        private javax.swing.JTextField inTxt;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JSeparator jSeparator3;
        private javax.swing.JLabel outLbl;
        private javax.swing.JTextArea outTxt;
        private javax.swing.JButton wsConnectBtn;
        private javax.swing.JButton wsDisconnectBtn;
        private javax.swing.JButton wsSendHelloBtn;
        private javax.swing.JLabel wsUrlLbl;
        private javax.swing.JTextField wsUrlTxt;
        // End of variables declaration//GEN-END:variables
}
